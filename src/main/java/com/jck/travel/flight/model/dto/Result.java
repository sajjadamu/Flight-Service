package com.jck.travel.flight.model.dto;


import java.util.LinkedList;
import java.util.List;

public class Result {

    private String origin;

    private String destination;

    private List<List<Flight>> results = new LinkedList<>();

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

    public List<List<Flight>> getResults() {
        return results;
    }

    public void setResults(List<Flight> results) {
        if (results != null)
            this.results.add(results);
    }
}
