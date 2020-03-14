package com.jck.travel.flight.model.co;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class FareCo {

    private String currency;

    private BigDecimal baseFare;

    private BigDecimal tax;

    private BigDecimal PGCharge;

    private BigDecimal otherCharges;

    private BigDecimal discount;

    private BigDecimal publishedFare;

    private BigDecimal commissionEarned;

    private BigDecimal PLBEarned;

    private BigDecimal incentiveEarned;

    private BigDecimal offeredFare;

    private BigDecimal tdsOnCommission;

    private BigDecimal tdsOnPLB;

    private BigDecimal tdsOnIncentive;

    private BigDecimal serviceFee;

    private BigDecimal totalBaggageCharges;

    private BigDecimal totalMealCharges;

    private BigDecimal totalSeatCharges;

    private BigDecimal totalSpecialServiceCharges;

    private BigDecimal YQTax;

    private BigDecimal additionalTxnFeeOfrd;

    private BigDecimal additionalTxnFeePub;

    private BigDecimal transactionFee;

    private BigDecimal airTransFee;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(BigDecimal baseFare) {
        this.baseFare = baseFare;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getPGCharge() {
        return PGCharge;
    }

    public void setPGCharge(BigDecimal PGCharge) {
        this.PGCharge = PGCharge;
    }

    public BigDecimal getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(BigDecimal otherCharges) {
        this.otherCharges = otherCharges;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPublishedFare() {
        return publishedFare;
    }

    public void setPublishedFare(BigDecimal publishedFare) {
        this.publishedFare = publishedFare;
    }

    public BigDecimal getCommissionEarned() {
        return commissionEarned;
    }

    public void setCommissionEarned(BigDecimal commissionEarned) {
        this.commissionEarned = commissionEarned;
    }

    public BigDecimal getPLBEarned() {
        return PLBEarned;
    }

    public void setPLBEarned(BigDecimal PLBEarned) {
        this.PLBEarned = PLBEarned;
    }

    public BigDecimal getIncentiveEarned() {
        return incentiveEarned;
    }

    public void setIncentiveEarned(BigDecimal incentiveEarned) {
        this.incentiveEarned = incentiveEarned;
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

    public BigDecimal getTdsOnPLB() {
        return tdsOnPLB;
    }

    public void setTdsOnPLB(BigDecimal tdsOnPLB) {
        this.tdsOnPLB = tdsOnPLB;
    }

    public BigDecimal getTdsOnIncentive() {
        return tdsOnIncentive;
    }

    public void setTdsOnIncentive(BigDecimal tdsOnIncentive) {
        this.tdsOnIncentive = tdsOnIncentive;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getTotalBaggageCharges() {
        return totalBaggageCharges;
    }

    public void setTotalBaggageCharges(BigDecimal totalBaggageCharges) {
        this.totalBaggageCharges = totalBaggageCharges;
    }

    public BigDecimal getTotalMealCharges() {
        return totalMealCharges;
    }

    public void setTotalMealCharges(BigDecimal totalMealCharges) {
        this.totalMealCharges = totalMealCharges;
    }

    public BigDecimal getTotalSeatCharges() {
        return totalSeatCharges;
    }

    public void setTotalSeatCharges(BigDecimal totalSeatCharges) {
        this.totalSeatCharges = totalSeatCharges;
    }

    public BigDecimal getTotalSpecialServiceCharges() {
        return totalSpecialServiceCharges;
    }

    public void setTotalSpecialServiceCharges(BigDecimal totalSpecialServiceCharges) {
        this.totalSpecialServiceCharges = totalSpecialServiceCharges;
    }

    public BigDecimal getYQTax() {
        return YQTax;
    }

    public void setYQTax(BigDecimal YQTax) {
        this.YQTax = YQTax;
    }

    public BigDecimal getAdditionalTxnFeeOfrd() {
        return additionalTxnFeeOfrd;
    }

    public void setAdditionalTxnFeeOfrd(BigDecimal additionalTxnFeeOfrd) {
        this.additionalTxnFeeOfrd = additionalTxnFeeOfrd;
    }

    public BigDecimal getAdditionalTxnFeePub() {
        return additionalTxnFeePub;
    }

    public void setAdditionalTxnFeePub(BigDecimal additionalTxnFeePub) {
        this.additionalTxnFeePub = additionalTxnFeePub;
    }

    public BigDecimal getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(BigDecimal transactionFee) {
        this.transactionFee = transactionFee;
    }

    public BigDecimal getAirTransFee() {
        return airTransFee;
    }

    public void setAirTransFee(BigDecimal airTransFee) {
        this.airTransFee = airTransFee;
    }

    public Map<String, ?> getTboRequest() {
        Map<String, Object> params = new LinkedHashMap<>();

        params.put("baseFare", this.baseFare);
        params.put("tax", this.tax);
        params.put("yqtax", this.YQTax);
        params.put("additionalTxnFeeOfrd", this.additionalTxnFeeOfrd);
        params.put("additionalTxnFeePub", this.additionalTxnFeePub);
        params.put("transactionFee", this.transactionFee);
        params.put("airTransFee", this.airTransFee);
        params.put("currency", this.currency);
        params.put("PGCharge", this.airTransFee);
        params.put("otherCharges", this.otherCharges);
        params.put("discount", this.discount);
        params.put("publishedFare", this.publishedFare);
        params.put("commissionEarned", this.commissionEarned);
        params.put("plbearned", this.PLBEarned);
        params.put("incentiveEarned", this.incentiveEarned);
        params.put("offeredFare", this.offeredFare);
        params.put("tdsOnCommission", this.tdsOnCommission);
        params.put("tdsOnPLB", this.tdsOnPLB);
        params.put("tdsOnIncentive", this.tdsOnIncentive);
        params.put("serviceFee", this.serviceFee);
        params.put("totalBaggageCharges", this.totalBaggageCharges);
        params.put("totalMealCharges", this.totalMealCharges);
        params.put("totalSeatCharges", this.totalSeatCharges);
        params.put("totalSpecialServiceCharges", this.totalSpecialServiceCharges);
        return params;
    }
}