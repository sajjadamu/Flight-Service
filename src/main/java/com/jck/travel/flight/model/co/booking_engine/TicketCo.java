package com.jck.travel.flight.model.co.booking_engine;

import org.json.JSONObject;

public class TicketCo {

    private Integer ticketId;

    private String ticketNumber;

    private String issueDate;

    private String validatingAirline;

    private String remarks;

    private String serviceFeeDisplayType;

    private String conjunctionNumber;

    private String ticketType;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getValidatingAirline() {
        return validatingAirline;
    }

    public void setValidatingAirline(String validatingAirline) {
        this.validatingAirline = validatingAirline;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getServiceFeeDisplayType() {
        return serviceFeeDisplayType;
    }

    public void setServiceFeeDisplayType(String serviceFeeDisplayType) {
        this.serviceFeeDisplayType = serviceFeeDisplayType;
    }

    public String getConjunctionNumber() {
        return conjunctionNumber;
    }

    public void setConjunctionNumber(String conjunctionNumber) {
        this.conjunctionNumber = conjunctionNumber;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public void setRequest(JSONObject response) {
        this.ticketId = response.getInt("ticketId");
        this.ticketNumber = response.getString("ticketNumber");
        this.issueDate = response.getString("issueDate");
        this.validatingAirline = response.getString("validatingAirline");
        this.remarks = response.getString("remarks");
        this.serviceFeeDisplayType = response.getString("serviceFeeDisplayType");
        this.conjunctionNumber = response.getString("conjunctionNumber");
        this.ticketType = response.getString("ticketType");
    }
}
