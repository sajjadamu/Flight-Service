package com.jck.travel.flight.model.dto;


public class Segment {

    private String id; // In Galileo(Key), In Tbo there is no segment id

    private String origin;

    private String destination;

    private String departureTime;

    private String arrivalTime;

    private String equipment; // craft in TBO

    private boolean isETicketEligible = false; // In Galileo (eTicketAbility), In TBO (isETicketEligible)

    private Integer duration; //In TBO (Duration & AccumulatedDuration) In Galileo(flightTime)

    private String remark; //In TBO (Remark)

    private Integer segmentIndicator; // In TBO

    private int noOfSeatAvailable;// In TBO (NoOfSeatAvailable)

    private Airport airport;

    private Airline airline;

    private Flight flight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public boolean isETicketEligible() {
        return isETicketEligible;
    }

    public void setETicketEligible(boolean isETicketEligible) {
        this.isETicketEligible = isETicketEligible;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSegmentIndicator() {
        return segmentIndicator;
    }

    public void setSegmentIndicator(Integer segmentIndicator) {
        this.segmentIndicator = segmentIndicator;
    }

    public int getNoOfSeatAvailable() {
        return noOfSeatAvailable;
    }

    public void setNoOfSeatAvailable(int noOfSeatAvailable) {
        this.noOfSeatAvailable = noOfSeatAvailable;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
