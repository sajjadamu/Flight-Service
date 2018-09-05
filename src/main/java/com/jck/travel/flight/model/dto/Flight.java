package com.jck.travel.flight.model.dto;

public class Flight {

    private String flightStatus; //In TBO

    private String flightNumber; //In TBO (AirLine.FlightNumber)

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
