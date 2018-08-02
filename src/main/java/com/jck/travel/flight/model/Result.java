package com.jck.travel.flight.model;


import com.jck.travel.flight.model.airline.Flight;

import java.util.LinkedList;
import java.util.List;

public class Result {

    private String origin;

    private String destination;

    private List<Flight> results = new LinkedList<>();

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

    public List<Flight> getResults() {
        return results;
    }

    public void setResults(Flight flight) {
        if (flight != null)
            this.results.add(flight);
    }
}
