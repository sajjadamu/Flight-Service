package com.jck.travel.flight.model.co.booking_engine;

import com.jck.travel.flight.util.enumeration.BookingStatus;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationCo {

    @NotNull
    private Date journeyDate;

    @NotBlank
    @NotNull
    private String pnr;

    @NotBlank
    @NotNull
    private String bookingId;

    @Enumerated(EnumType.STRING)
    private @NotNull @NotBlank BookingStatus status;

    private boolean isTimeChanged;

    private boolean isPriceChanged;

    private boolean isManual;

    private boolean isNonRefundable;

    private String SSRMessage;

    private boolean SSRDenied;

    private String provider;

    private BigDecimal conversionRateBookingTime;

    private BigDecimal totalAmount;

    private BigDecimal totalTaxAmount;

    private BigDecimal totalDiscountAmount;

    private BigDecimal totalTDSAmount;

    private BigDecimal totalCancellationAmount; //Has to paid when apply for cancellation

    private Integer totalPassengerCount;

    private String user; //mappedBy EntityId

    private FareCo fare;

    private List<FareRuleCo> fareRules = new ArrayList<>();

    private InvoiceCo invoice;

    private JourneyCo journey;

    public @NotBlank @NotNull String getPnr() {
        return pnr;
    }

    public void setPnr(@NotBlank @NotNull String pnr) {
        this.pnr = pnr;
    }

    public InvoiceCo getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceCo invoice) {
        this.invoice = invoice;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getStatus() {
        return status.toString();
    }

    public void setStatus(String status) {
        if (status != null) {
            this.status = BookingStatus.from(status);
        }
    }

    public boolean isTimeChanged() {
        return isTimeChanged;
    }

    public void setTimeChanged(boolean isTimeChanged) {
        this.isTimeChanged = isTimeChanged;
    }

    public boolean isPriceChanged() {
        return isPriceChanged;
    }

    public void setPriceChanged(boolean isPriceChanged) {
        this.isPriceChanged = isPriceChanged;
    }

    public boolean isManual() {
        return isManual;
    }

    public void setManual(boolean isManual) {
        this.isManual = isManual;
    }

    public boolean isNonRefundable() {
        return isNonRefundable;
    }

    public void setNonRefundable(boolean isNonRefundable) {
        this.isNonRefundable = isNonRefundable;
    }

    public String getSSRMessage() {
        return SSRMessage;
    }

    public void setSSRMessage(String SSRMessage) {
        this.SSRMessage = SSRMessage;
    }

    public boolean isSSRDenied() {
        return SSRDenied;
    }

    public void setSSRDenied(boolean SSRDenied) {
        this.SSRDenied = SSRDenied;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public FareCo getFare() {
        return fare;
    }

    public void setFare(FareCo fare) {
        this.fare = fare;
    }

    public List<FareRuleCo> getFareRules() {
        return this.fareRules;
    }

    public void setFareRules(FareRuleCo fareRule) {
        if (fareRule != null)
            this.fareRules.add(fareRule);
    }

    public BigDecimal getConversionRateBookingTime() {
        return conversionRateBookingTime;
    }

    public void setConversionRateBookingTime(BigDecimal conversionRateBookingTime) {
        this.conversionRateBookingTime = conversionRateBookingTime;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalTaxAmount() {
        return totalTaxAmount;
    }

    public void setTotalTaxAmount(BigDecimal totalTaxAmount) {
        this.totalTaxAmount = totalTaxAmount;
    }

    public BigDecimal getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    public void setTotalDiscountAmount(BigDecimal totalDiscountAmount) {
        this.totalDiscountAmount = totalDiscountAmount;
    }

    public BigDecimal getTotalTDSAmount() {
        return totalTDSAmount;
    }

    public void setTotalTDSAmount(BigDecimal totalTDSAmount) {
        this.totalTDSAmount = totalTDSAmount;
    }

    public BigDecimal getTotalCancellationAmount() {
        return totalCancellationAmount;
    }

    public void setTotalCancellationAmount(BigDecimal totalCancellationAmount) {
        this.totalCancellationAmount = totalCancellationAmount;
    }

    public Integer getTotalPassengerCount() {
        return totalPassengerCount;
    }

    public void setTotalPassengerCount(Integer totalPassengerCount) {
        this.totalPassengerCount = totalPassengerCount;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public JourneyCo getJourney() {
        return journey;
    }

    public void setJourney(JourneyCo journey) {
        this.journey = journey;
    }

    public void setRequest(JSONObject response, boolean isHolding) {
        if (isHolding)
            setHolding(response);
        else
            setTicket(response);
    }

    private void setTicket(JSONObject response) {
        this.setJourneyDate(null);
        this.setPnr(response.getString("PNR"));
        this.setBookingId(String.valueOf(response.getInt("bookingId")));
        this.setStatus(response.getString("bookingStatus"));
        this.setTimeChanged(response.getBoolean("isTimeChanged"));
        this.setPriceChanged(response.getBoolean("isPriceChanged"));
        this.setManual(response.getJSONObject("ticket").getBoolean("isManual"));
        this.setNonRefundable(response.getJSONObject("ticket").getBoolean("nonRefundable"));
        this.setSSRMessage("");
        this.setSSRDenied(false);
        // TODO need to set provider from API response
        this.setProvider("AI");
        this.setConversionRateBookingTime(new BigDecimal(0.0));
        this.setTotalAmount(response.getJSONObject("ticket").getJSONObject("invoice").getBigDecimal("invoiceAmount"));
        this.setTotalTaxAmount(new BigDecimal(0.0));
        this.setTotalDiscountAmount(new BigDecimal(0.0));
        this.setTotalTDSAmount(new BigDecimal(0.0));
        this.setTotalCancellationAmount(new BigDecimal(0.0));
        this.setTotalPassengerCount(response.getJSONObject("ticket").getJSONArray("passengers").length());
        // TODO need to communicate with Auth API to get user
        this.setUser("1");

        FareCo fareCo = new FareCo();
        JSONObject fare = response.getJSONObject("ticket").getJSONObject("fare");
        fare.put("fareType", response.getJSONObject("ticket").getString("fareType"));
        fareCo.setRequest(fare);
        this.setFare(fareCo);

        JSONArray fareRules = response.getJSONObject("ticket").getJSONArray("fareRules");
        for (int i = 0; i < fareRules.length(); i++) {
            FareRuleCo fareRuleCo = new FareRuleCo();
            fareRuleCo.setRequest(fareRules.getJSONObject(i));
            this.setFareRules(fareRuleCo);
        }

        if (response.has("invoice")) {
            InvoiceCo invoiceCo = new InvoiceCo();
            JSONObject invoice = response.getJSONObject("ticket").getJSONObject("invoice");
            invoice.put("airlineCode", response.getJSONObject("ticket").getString("airlineCode"));
            invoice.put("airlineTollFreeNo", response.getJSONObject("ticket").getString("airlineTollFreeNo"));
            invoiceCo.setRequest(invoice);
            this.setInvoice(invoiceCo);
        }

        JourneyCo journeyCo = new JourneyCo();
        journeyCo.setRequest(response.getJSONObject("ticket"));
        this.setJourney(journeyCo);
    }

    private void setHolding(JSONObject response) {
        this.setJourneyDate(null);

        this.setPnr(response.getString("PNR"));
        this.setBookingId(String.valueOf(response.getInt("bookingId")));
        this.setStatus(response.getString("status"));
        this.setTimeChanged(response.getBoolean("isTimeChanged"));
        this.setPriceChanged(response.getBoolean("isPriceChanged"));
        this.setManual(response.getJSONObject("booking").getBoolean("isManual"));
        this.setNonRefundable(response.getJSONObject("booking").getBoolean("nonRefundable"));
        this.setSSRMessage("");
        this.setSSRDenied(false);
        // TODO need to set provider from API response
        this.setProvider("AI");
        this.setConversionRateBookingTime(new BigDecimal(0.0));
        this.setTotalAmount(new BigDecimal(0.0));
        this.setTotalTaxAmount(new BigDecimal(0.0));
        this.setTotalDiscountAmount(new BigDecimal(0.0));
        this.setTotalTDSAmount(new BigDecimal(0.0));
        this.setTotalCancellationAmount(new BigDecimal(0.0));
        this.setTotalPassengerCount(response.getJSONObject("booking").getJSONArray("passengers").length());
        // TODO need to communicate with Auth API to get user
        this.setUser("1");

        FareCo fareCo = new FareCo();
        JSONObject fare = response.getJSONObject("booking").getJSONObject("fare");
        fare.put("fareType", response.getJSONObject("booking").getString("fareType"));
        fareCo.setRequest(fare);
        this.setFare(fareCo);

        JSONArray fareRules = response.getJSONObject("booking").getJSONArray("fareRules");
        for (int i = 0; i < fareRules.length(); i++) {
            FareRuleCo fareRuleCo = new FareRuleCo();
            fareRuleCo.setRequest(fareRules.getJSONObject(i));
            this.setFareRules(fareRuleCo);
        }

        JourneyCo journeyCo = new JourneyCo();
        JSONObject object = response.getJSONObject("booking");
        object.put("isLCC", false);
        journeyCo.setRequest(object);
        this.setJourney(journeyCo);
    }
}
