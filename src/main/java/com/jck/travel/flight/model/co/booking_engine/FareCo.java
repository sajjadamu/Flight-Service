package com.jck.travel.flight.model.co.booking_engine;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FareCo {

    private String fareType;

    private BigDecimal additionalTxnFeePub;

    private BigDecimal totalBaggageCharges;

    private BigDecimal discount;

    private BigDecimal totalSeatCharges;

    private BigDecimal tdsOnIncentive;

    private BigDecimal baseFare;

    private BigDecimal commissionEarned;

    private BigDecimal tax;

    private BigDecimal incentiveEarned;

    private BigDecimal serviceFee;

    private BigDecimal additionalTxnFeeOfrd;

    private BigDecimal totalMealCharges;

    private String currency;

    private BigDecimal totalSpecialServiceCharges;

    private BigDecimal offeredFare;

    private BigDecimal tdsOnCommission;

    private BigDecimal otherCharges;

    private BigDecimal publishedFare;

    private BigDecimal YQTax;

    private BigDecimal PGCharge;

    private BigDecimal PLBEarned;

    private BigDecimal TdsOnPLB;

    private List<TaxBreakUpCo> taxBreakUps = new ArrayList<>();

    public String getFareType() {
        return fareType;
    }

    public void setFareType(String fareType) {
        this.fareType = fareType;
    }

    public BigDecimal getAdditionalTxnFeePub() {
        return additionalTxnFeePub;
    }

    public void setAdditionalTxnFeePub(BigDecimal additionalTxnFeePub) {
        this.additionalTxnFeePub = additionalTxnFeePub;
    }

    public BigDecimal getTotalBaggageCharges() {
        return totalBaggageCharges;
    }

    public void setTotalBaggageCharges(BigDecimal totalBaggageCharges) {
        this.totalBaggageCharges = totalBaggageCharges;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotalSeatCharges() {
        return totalSeatCharges;
    }

    public void setTotalSeatCharges(BigDecimal totalSeatCharges) {
        this.totalSeatCharges = totalSeatCharges;
    }

    public BigDecimal getTdsOnIncentive() {
        return tdsOnIncentive;
    }

    public void setTdsOnIncentive(BigDecimal tdsOnIncentive) {
        this.tdsOnIncentive = tdsOnIncentive;
    }

    public BigDecimal getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(BigDecimal baseFare) {
        this.baseFare = baseFare;
    }

    public BigDecimal getCommissionEarned() {
        return commissionEarned;
    }

    public void setCommissionEarned(BigDecimal commissionEarned) {
        this.commissionEarned = commissionEarned;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getIncentiveEarned() {
        return incentiveEarned;
    }

    public void setIncentiveEarned(BigDecimal incentiveEarned) {
        this.incentiveEarned = incentiveEarned;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getAdditionalTxnFeeOfrd() {
        return additionalTxnFeeOfrd;
    }

    public void setAdditionalTxnFeeOfrd(BigDecimal additionalTxnFeeOfrd) {
        this.additionalTxnFeeOfrd = additionalTxnFeeOfrd;
    }

    public BigDecimal getTotalMealCharges() {
        return totalMealCharges;
    }

    public void setTotalMealCharges(BigDecimal totalMealCharges) {
        this.totalMealCharges = totalMealCharges;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getTotalSpecialServiceCharges() {
        return totalSpecialServiceCharges;
    }

    public void setTotalSpecialServiceCharges(BigDecimal totalSpecialServiceCharges) {
        this.totalSpecialServiceCharges = totalSpecialServiceCharges;
    }

    public BigDecimal getOfferedFare() {
        return offeredFare;
    }

    public void setOfferedFare(BigDecimal offeredFare) {
        this.offeredFare = offeredFare;
    }

    public BigDecimal getTdsOnCommission() {
        return tdsOnCommission;
    }

    public void setTdsOnCommission(BigDecimal tdsOnCommission) {
        this.tdsOnCommission = tdsOnCommission;
    }

    public BigDecimal getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(BigDecimal otherCharges) {
        this.otherCharges = otherCharges;
    }

    public BigDecimal getPublishedFare() {
        return publishedFare;
    }

    public void setPublishedFare(BigDecimal publishedFare) {
        this.publishedFare = publishedFare;
    }

    public BigDecimal getYQTax() {
        return YQTax;
    }

    public void setYQTax(BigDecimal YQTax) {
        this.YQTax = YQTax;
    }

    public BigDecimal getPGCharge() {
        return PGCharge;
    }

    public void setPGCharge(BigDecimal PGCharge) {
        this.PGCharge = PGCharge;
    }

    public BigDecimal getPLBEarned() {
        return PLBEarned;
    }

    public void setPLBEarned(BigDecimal PLBEarned) {
        this.PLBEarned = PLBEarned;
    }

    public BigDecimal getTdsOnPLB() {
        return TdsOnPLB;
    }

    public void setTdsOnPLB(BigDecimal tdsOnPLB) {
        TdsOnPLB = tdsOnPLB;
    }

    public List<TaxBreakUpCo> getTaxBreakUps() {
        return taxBreakUps;
    }

    public void setTaxBreakUps(TaxBreakUpCo taxBreakUp) {
        if (taxBreakUp != null)
            this.taxBreakUps.add(taxBreakUp);
    }

    public void setRequest(JSONObject fare) {

        if (fare.has("fareType"))
            this.setFareType(fare.getString("fareType"));

        this.setAdditionalTxnFeePub(fare.getBigDecimal("additionalTxnFeePub"));
        this.setTotalBaggageCharges(fare.getBigDecimal("totalBaggageCharges"));
        this.setDiscount(fare.getBigDecimal("discount"));
        this.setTotalSeatCharges(fare.getBigDecimal("totalSeatCharges"));
        this.setTdsOnIncentive(fare.getBigDecimal("tdsOnIncentive"));
        this.setBaseFare(fare.getBigDecimal("baseFare"));
        this.setCommissionEarned(fare.getBigDecimal("commissionEarned"));
        this.setTax(fare.getBigDecimal("totalTaxes"));
        this.setIncentiveEarned(fare.getBigDecimal("incentiveEarned"));
        this.setServiceFee(fare.getBigDecimal("serviceFee"));
        this.setAdditionalTxnFeeOfrd(fare.getBigDecimal("additionalTxnFeeOfrd"));
        this.setTotalMealCharges(fare.getBigDecimal("totalMealCharges"));
        this.setCurrency(fare.getString("currency"));
        this.setTotalSpecialServiceCharges(fare.getBigDecimal("totalSpecialServiceCharges"));
        this.setOfferedFare(fare.getBigDecimal("offeredFare"));
        this.setTdsOnCommission(fare.getBigDecimal("tdsOnCommission"));
        this.setOtherCharges(fare.getBigDecimal("otherCharges"));
        this.setPublishedFare(fare.getBigDecimal("publishedFare"));
        this.setYQTax(fare.getBigDecimal("YQTax"));
        this.setPGCharge(fare.getBigDecimal("PGCharge"));

        if (fare.has("PLBEarned"))
            this.setPLBEarned(fare.getBigDecimal("PLBEarned"));

        this.setTdsOnPLB(fare.getBigDecimal("TdsOnPLB"));

        JSONArray taxes = fare.getJSONArray("taxBreakUp");

        for (int i = 0; i < taxes.length(); i++) {
            TaxBreakUpCo taxBreakUpCo = new TaxBreakUpCo();
            taxBreakUpCo.setCategory(taxes.getJSONObject(i).getString("category"));
            taxBreakUpCo.setAmount(taxes.getJSONObject(i).getBigDecimal("amount"));
            this.setTaxBreakUps(taxBreakUpCo);
        }
    }
}
