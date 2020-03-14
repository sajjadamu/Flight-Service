package com.jck.travel.flight.model.co.booking_engine;

import org.json.JSONObject;

public class AirLineCo {

    private String airlineCode;

    private String airlineRemark;

    private String airlineName;

    public void setRequest(JSONObject airline) {
        this.setAirlineCode(airline.getString("airlineCode"));
        this.setAirlineName(airline.getString("airlineName"));

        if (airline.has("airlineRemark"))
            this.setAirlineRemark(airline.getString("airlineRemark"));
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getAirlineRemark() {
        return airlineRemark;
    }

    public void setAirlineRemark(String airlineRemark) {
        this.airlineRemark = airlineRemark;
    }
}
