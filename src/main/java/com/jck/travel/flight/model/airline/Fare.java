package com.jck.travel.flight.model.airline;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Fare {

  /*
    private boolean negotiatedFare;
    private String fareBasis;
    private String effectiveDate;
    private Map<String, ?> fareRuleKey;
    private String approximateBasePrice;
    private String approximateTaxes;
   */

    private String id;
    /*
     * Only for TBO fare Object
     */

    private List<TaxBreakUp> taxBreakUp;

    private BigDecimal additionalTxnFeePub;

    private BigDecimal totalBaggageCharges;

    private BigDecimal discount;

    private BigDecimal totalSeatCharges;

    private BigDecimal tdsOnIncentive;

    private BigDecimal commissionEarned;

    private BigDecimal incentiveEarned;

    private BigDecimal serviceFee;

    private BigDecimal additionalTxnFeeOfrd;

    private BigDecimal totalMealCharges;

    private BigDecimal totalSpecialServiceCharges;

    private BigDecimal offeredFare;

    private BigDecimal tdsOnCommission;

    private BigDecimal otherCharges;

    private BigDecimal YQTax;

    private BigDecimal PGCharge;

    private BigDecimal PLBEarned;

    private BigDecimal TdsOnPLB;

    /*
     * Ends here for only and starting for Others
     */

    private String currency; // For TBO & Galileo

    private String fareCalculator; // For Galileo

    private Map<String, ?> baggageAllowance;

    private BigDecimal publishedFare;// For Galileo(totalFare) & publishedFare for TBO

    private BigDecimal baseFare; // For TBO & Galileo

    private BigDecimal totalTaxes; // For TBO & Galileo

    private String lastTicketingTime;

    private String pricingMethod;

    private String platingCarrier;

    private Map<String, ?> baggageAllowances;

    private FareBreakDown fareBreakDown;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public BigDecimal getCommissionEarned() {
        return commissionEarned;
    }

    public void setCommissionEarned(BigDecimal commissionEarned) {
        this.commissionEarned = commissionEarned;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFareCalculator() {
        return fareCalculator;
    }

    public void setFareCalculator(String fareCalculator) {
        this.fareCalculator = fareCalculator;
    }

    public Map<String, ?> getBaggageAllowance() {
        return baggageAllowance;
    }

    public void setBaggageAllowance(Map<String, ?> baggageAllowance) {
        this.baggageAllowance = baggageAllowance;
    }

    public BigDecimal getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(BigDecimal baseFare) {
        this.baseFare = baseFare;
    }

    public BigDecimal getTotalTaxes() {
        return totalTaxes;
    }

    public void setTotalTaxes(BigDecimal totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public String getLastTicketingTime() {
        return lastTicketingTime;
    }

    public void setLastTicketingTime(String lastTicketingTime) {
        this.lastTicketingTime = lastTicketingTime;
    }

    public String getPricingMethod() {
        return pricingMethod;
    }

    public void setPricingMethod(String pricingMethod) {
        this.pricingMethod = pricingMethod;
    }

    public String getPlatingCarrier() {
        return platingCarrier;
    }

    public void setPlatingCarrier(String platingCarrier) {
        this.platingCarrier = platingCarrier;
    }

    public Map<String, ?> getBaggageAllowances() {
        return baggageAllowances;
    }

    public void setBaggageAllowances(Map<String, ?> baggageAllowances) {
        this.baggageAllowances = baggageAllowances;
    }

    public FareBreakDown getFareBreakDown() {
        return fareBreakDown;
    }

    public void setFareBreakDown(FareBreakDown fareBreakDown) {
        this.fareBreakDown = fareBreakDown;
    }

    public List<TaxBreakUp> getTaxBreakUp() {
        return taxBreakUp;
    }

    public void setTaxBreakUp(List<TaxBreakUp> taxBreakUp) {
        this.taxBreakUp = taxBreakUp;
    }
}
