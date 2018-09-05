package com.jck.travel.flight.model.dto;

public class Fare {

    private String id;

    private String currency; // For TBO & Galileo

    private Double baseFare; // Same for both TBO & Galileo

    private Double publishedFare; //In Galileo(totalFare) In TBO(publishedFare)

    private Double totalTaxes; // For TBO & Galileo

    private Double yqTax;

    public Double getYqTax() {
        return yqTax;
    }

    public void setYqTax(Double yqTax) {
        this.yqTax = yqTax;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(Double baseFare) {
        this.baseFare = baseFare;
    }

    public Double getPublishedFare() {
        return publishedFare;
    }

    public void setPublishedFare(Double publishedFare) {
        this.publishedFare = publishedFare;
    }

    public Double getTotalTaxes() {
        return totalTaxes;
    }

    public void setTotalTaxes(Double totalTaxes) {
        this.totalTaxes = totalTaxes;
    }
}
