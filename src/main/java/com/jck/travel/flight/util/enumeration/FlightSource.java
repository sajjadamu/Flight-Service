package com.jck.travel.flight.util.enumeration;


public enum FlightSource {

    GAL("1G"),
    TBO("TBO");

    private final String source;

    FlightSource(final String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }
}
