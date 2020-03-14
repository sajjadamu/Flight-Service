package com.jck.travel.flight.model.co.booking_engine;

import org.json.JSONObject;

public class SegmentCo {

    /*
    "baggage":null,
    "cabinBaggage":null,
    "tripIndicator":1,
    */

    private String origin;

    private String originDepTime;

    private String originAirportName;

    private String originTerminal;

    private String destination;

    private String destinationAirportName;

    private String destinationTerminal;

    private String destinationArrTime;

    private int segmentIndicator;

    private String flightNumber;

    private String fareClass; //Future Use

    private AirLineCo airLine;

    private String flightStatusCode; //status in API

    private String flightStatus;

    private boolean isETicketEligible;

    private Integer groundTime; //need to verify response in API

    private String craft;

    private Integer duration;

    private Integer mile;

    private boolean stopOver;

    private Integer accumulatedDuration; //need to check in TBO response for Holding

    private String remark;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOriginDepTime() {
        return originDepTime;
    }

    public void setOriginDepTime(String originDepTime) {
        this.originDepTime = originDepTime;
    }

    public String getOriginAirportName() {
        return originAirportName;
    }

    public void setOriginAirportName(String originAirportName) {
        this.originAirportName = originAirportName;
    }

    public String getOriginTerminal() {
        return originTerminal;
    }

    public void setOriginTerminal(String originTerminal) {
        this.originTerminal = originTerminal;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestinationAirportName() {
        return destinationAirportName;
    }

    public void setDestinationAirportName(String destinationAirportName) {
        this.destinationAirportName = destinationAirportName;
    }

    public String getDestinationTerminal() {
        return destinationTerminal;
    }

    public void setDestinationTerminal(String destinationTerminal) {
        this.destinationTerminal = destinationTerminal;
    }

    public String getDestinationArrTime() {
        return destinationArrTime;
    }

    public void setDestinationArrTime(String destinationArrTime) {
        this.destinationArrTime = destinationArrTime;
    }

    public int getSegmentIndicator() {
        return segmentIndicator;
    }

    public void setSegmentIndicator(int segmentIndicator) {
        this.segmentIndicator = segmentIndicator;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFareClass() {
        return fareClass;
    }

    public void setFareClass(String fareClass) {
        this.fareClass = fareClass;
    }

    public AirLineCo getAirLine() {
        return airLine;
    }

    public void setAirLine(AirLineCo airLine) {
        this.airLine = airLine;
    }

    public String getFlightStatusCode() {
        return flightStatusCode;
    }

    public void setFlightStatusCode(String flightStatusCode) {
        this.flightStatusCode = flightStatusCode;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public boolean isETicketEligible() {
        return isETicketEligible;
    }

    public void setETicketEligible(boolean isETicketEligible) {
        this.isETicketEligible = isETicketEligible;
    }

    public Integer getGroundTime() {
        return groundTime;
    }

    public void setGroundTime(Integer groundTime) {
        this.groundTime = groundTime;
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getMile() {
        return mile;
    }

    public void setMile(Integer mile) {
        this.mile = mile;
    }

    public boolean isStopOver() {
        return stopOver;
    }

    public void setStopOver(boolean stopOver) {
        this.stopOver = stopOver;
    }

    public Integer getAccumulatedDuration() {
        return accumulatedDuration;
    }

    public void setAccumulatedDuration(Integer accumulatedDuration) {
        this.accumulatedDuration = accumulatedDuration;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setRequest(JSONObject response) {

        this.setOrigin(response.getJSONObject("origin").getString("airportCode"));
        this.setOriginDepTime(response.getJSONObject("origin").getString("originDepTime"));
        this.setOriginAirportName(response.getJSONObject("origin").getString("airportName"));
        this.setOriginTerminal(response.getJSONObject("origin").getString("terminal"));
        this.setDestination(response.getJSONObject("destination").getString("airportCode"));
        this.setDestinationAirportName(response.getJSONObject("destination").getString("airportName"));
        this.setDestinationTerminal(response.getJSONObject("destination").getString("terminal"));
        this.setDestinationArrTime(response.getJSONObject("destination").getString("destinationArrTime"));
        this.setSegmentIndicator(response.getInt("segmentIndicator"));
        this.setFlightNumber(response.getString("flightNumber"));

        AirLineCo airLineCo = new AirLineCo();
        airLineCo.setRequest(response.getJSONObject("airline"));
        this.setAirLine(airLineCo);

        this.setFlightStatusCode(response.getString("status")); //status in API
        this.setFlightStatus(response.getString("flightStatus"));
        this.setETicketEligible(response.getBoolean("isETicketEligible"));
        this.setGroundTime(response.getInt("groundTime")); //need to verify response in API
        this.setCraft(response.getString("craft"));
        this.setDuration(response.getInt("duration"));
        this.setMile(response.getInt("mile"));
        this.setStopOver(response.getBoolean("stopOver"));

        if (response.has("AccumulatedDuration") && !response.isNull("AccumulatedDuration"))
            this.setAccumulatedDuration(response.getInt("AccumulatedDuration"));

        if (response.has("remark") && !response.isNull("remark"))
            this.setRemark(response.getString("remark"));
    }
}
