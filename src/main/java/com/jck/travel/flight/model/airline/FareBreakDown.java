package com.jck.travel.flight.model.airline;


import com.jck.travel.flight.util.enumeration.PaxType;

import java.math.BigDecimal;
import java.util.Map;

public class FareBreakDown {

    private String id;

    private String totalFare;

    private String baseFare; // Same for TBO, Galileo

    private BigDecimal totalTax; //For TBO

    private TaxBreakUp taxBreakUp; // This properties for TBO ("YQTax","PGCharge"), and galileo gives full breakup

    private PaxType passengerType;

    private Map<String, ?> changePenalty; // For Galileo

    private Map<String, ?> cancelPenalty; // For Galileo

    private BigDecimal additionalTxnFeePub;

    private BigDecimal additionalTxnFeeOfrd;

    private String currency;

    public String getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(String totalFare) {
        this.totalFare = totalFare;
    }

    public String getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(String baseFare) {
        this.baseFare = baseFare;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public TaxBreakUp getTaxBreakUp() {
        return taxBreakUp;
    }

    public void setTaxBreakUp(TaxBreakUp taxBreakUp) {
        this.taxBreakUp = taxBreakUp;
    }

    public PaxType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PaxType passengerType) {
        this.passengerType = passengerType;
    }

    public Map<String, ?> getChangePenalty() {
        return changePenalty;
    }

    public void setChangePenalty(Map<String, ?> changePenalty) {
        this.changePenalty = changePenalty;
    }

    public Map<String, ?> getCancelPenalty() {
        return cancelPenalty;
    }

    public void setCancelPenalty(Map<String, ?> cancelPenalty) {
        this.cancelPenalty = cancelPenalty;
    }

    public BigDecimal getAdditionalTxnFeePub() {
        return additionalTxnFeePub;
    }

    public void setAdditionalTxnFeePub(BigDecimal additionalTxnFeePub) {
        this.additionalTxnFeePub = additionalTxnFeePub;
    }

    public BigDecimal getAdditionalTxnFeeOfrd() {
        return additionalTxnFeeOfrd;
    }

    public void setAdditionalTxnFeeOfrd(BigDecimal additionalTxnFeeOfrd) {
        this.additionalTxnFeeOfrd = additionalTxnFeeOfrd;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
