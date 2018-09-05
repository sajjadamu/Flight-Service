package com.jck.travel.flight.model.dto;


import com.jck.travel.flight.util.enumeration.PaxType;

public class FareBreakDown {

    private String id;

    private String totalFare;

    private Double baseFare; // Same for TBO, Galileo

    private Double totalTax; //For TBO

    private String yqTax;

    private Double gstAmount;

    private PaxType passengerType;

    private String reschedulePenalty; // In Galileo(), In TBO

    private String cancelPenalty; // For Galileo

    private String currency;

    private String baggageAllowance;//In TBO (Baggage in Segment) In Galileo ("fareInfo".baggageAllowance pax wise)

    private String cabinBaggage; //In TBO (CabinBaggage in segment)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(String totalFare) {
        this.totalFare = totalFare;
    }

    public Double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(Double baseFare) {
        this.baseFare = baseFare;
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Double totalTax) {
        this.totalTax = totalTax;
    }

    public String getYqTax() {
        return yqTax;
    }

    public void setYqTax(String yqTax) {
        this.yqTax = yqTax;
    }

    public Double getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(Double gstAmount) {
        this.gstAmount = gstAmount;
    }

    public PaxType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PaxType passengerType) {
        this.passengerType = passengerType;
    }

    public String getReschedulePenalty() {
        return reschedulePenalty;
    }

    public void setReschedulePenalty(String reschedulePenalty) {
        this.reschedulePenalty = reschedulePenalty;
    }

    public String getCancelPenalty() {
        return cancelPenalty;
    }

    public void setCancelPenalty(String cancelPenalty) {
        this.cancelPenalty = cancelPenalty;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBaggageAllowance() {
        return baggageAllowance;
    }

    public void setBaggageAllowance(String baggageAllowance) {
        this.baggageAllowance = baggageAllowance;
    }

    public String getCabinBaggage() {
        return cabinBaggage;
    }

    public void setCabinBaggage(String cabinBaggage) {
        this.cabinBaggage = cabinBaggage;
    }
}
