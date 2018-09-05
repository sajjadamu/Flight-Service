package com.jck.travel.flight.model.dto;

public class FareBreakDown {

    private String id;

    private boolean isRefundable;

    private Double totalFare;

    private Double baseFare; // Same for TBO, Galileo

    private Double totalTax; //For TBO

    private Double yqTax;

    private String passengerType;

    private Double reschedulePenalty; // In Galileo(), In TBO

    private Double cancelPenalty; // For Galileo

    private String currency;

    private String baggageAllowance;//In TBO (Baggage in Segment) In Galileo ("fareInfo".baggageAllowance pax wise)

    private String cabinBaggage; //In TBO (CabinBaggage in segment)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(Double totalFare) {
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

    public Double getYqTax() {
        return yqTax;
    }

    public void setYqTax(Double yqTax) {
        this.yqTax = yqTax;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public Double getReschedulePenalty() {
        return reschedulePenalty;
    }

    public void setReschedulePenalty(Double reschedulePenalty) {
        this.reschedulePenalty = reschedulePenalty;
    }

    public Double getCancelPenalty() {
        return cancelPenalty;
    }

    public void setCancelPenalty(Double cancelPenalty) {
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
