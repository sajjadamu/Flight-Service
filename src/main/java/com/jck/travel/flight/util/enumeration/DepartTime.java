package com.jck.travel.flight.util.enumeration;

public enum DepartTime {
    ANY("Any"),
    NIGHT("Night"),
    DAY("Day"),
    NOON("Noon"),
    EVENING("Evening");

    private final String time;

    DepartTime(final String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String toString() {
        return time;
    }
}
