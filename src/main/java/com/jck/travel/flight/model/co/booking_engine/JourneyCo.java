package com.jck.travel.flight.model.co.booking_engine;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JourneyCo {

    private List<PassengerCo> passengers = new ArrayList<>();

    private List<SegmentCo> segments = new ArrayList<>();

    private String source;

    private String destination;

    private boolean isDomestic;

    private boolean isLCC;

    public List<PassengerCo> getPassengers() {
        return passengers;
    }

    public void setPassengers(PassengerCo passenger) {
        if (passenger != null)
            this.passengers.add(passenger);
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isDomestic() {
        return isDomestic;
    }

    public void setDomestic(boolean isDomestic) {
        this.isDomestic = isDomestic;
    }

    public boolean isLCC() {
        return isLCC;
    }

    public void setLCC(boolean isLCC) {
        this.isLCC = isLCC;
    }

    public List<SegmentCo> getSegments() {
        return segments;
    }

    public void setSegments(SegmentCo segment) {
        if (segment != null)
            this.segments.add(segment);
    }

    public JourneyCo setRequest(JSONObject response) {

        JSONArray passengers = response.getJSONArray("passengers");
        for (int i = 0; i < passengers.length(); i++) {
            PassengerCo passengerCo = new PassengerCo();
            passengerCo.setRequest(passengers.getJSONObject(i));
            this.setPassengers(passengerCo);
        }

        JSONArray segments = response.getJSONArray("segments");
        for (int i = 0; i < segments.length(); i++) {
            SegmentCo segmentCo = new SegmentCo();
            segmentCo.setRequest(segments.getJSONObject(i));
            this.setSegments(segmentCo);
        }

        this.setSource(response.getString("origin"));
        this.setDestination(response.getString("destination"));
        this.setDomestic(response.getBoolean("isDomestic"));
        this.setLCC(response.getBoolean("isLCC"));

        return this;
    }
}
