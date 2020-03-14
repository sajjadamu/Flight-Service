package com.jck.travel.flight.util.enumeration;

public enum PaxType {

    ADULT(1),
    CHILD(2),
    INFANT(3),
    NOT_FOUND(-1);

    private int paxType;

    PaxType(final int paxType) {
        this.paxType = paxType;
    }

    public int getPaxType() {
        return paxType;
    }

    public static PaxType from(String type) {
        if (type.equalsIgnoreCase("adult"))
            return PaxType.ADULT;
        else if (type.equalsIgnoreCase("child"))
            return PaxType.CHILD;
        else if (type.equalsIgnoreCase("infant"))
            return PaxType.INFANT;
        else
            return PaxType.NOT_FOUND;
    }
}
