package com.jck.travel.flight.util.enumeration;

public enum PaxType {

    ADULT("ADULT"),
    CHILD("CHILD"),
    INFANT("INFANT");

    private String paxType;

    PaxType(final String paxType) {
        this.paxType = paxType;
    }

    public String getPaxType() {
        return paxType;
    }

}
