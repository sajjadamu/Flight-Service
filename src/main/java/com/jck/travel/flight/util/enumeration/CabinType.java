package com.jck.travel.flight.util.enumeration;

public enum CabinType {

    ANY(1),
    ECONOMY(2),
    PREMIUM_ECONOMY(3),
    BUSINESS(4),
    PREMIUM_BUSINESS(5),
    FIRST(6);

    private final int typeNo;

    CabinType(int typeNo) {
        this.typeNo = typeNo;
    }

    public int getTypeNo() {
        return typeNo;
    }
}
