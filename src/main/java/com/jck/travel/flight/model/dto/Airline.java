package com.jck.travel.flight.model.dto;

public class Airline {

    private String code; // In TBO(AirLine.AirlineCode) In Galileo (segment.carrier)

    private String name; // In TBO(AirLine.AirlineName)

    private String remark;

    private String fareClass;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFareClass() {
        return fareClass;
    }

    public void setFareClass(String fareClass) {
        this.fareClass = fareClass;
    }
}
