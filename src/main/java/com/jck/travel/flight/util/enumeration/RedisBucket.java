package com.jck.travel.flight.util.enumeration;

public enum RedisBucket {

    TOKEN("Token"),
    USER_FLIGHT_SEARCH("User Flight Search"),
    FLIGHT_SEARCH("Flight Search");

    private String bucket;

    RedisBucket(final String bucket) {
        this.bucket = bucket;
    }

    public String getBucket() {
        return bucket;
    }

    @Override
    public String toString() {
        return bucket;
    }
}
