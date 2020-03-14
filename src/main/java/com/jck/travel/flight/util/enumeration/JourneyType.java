package com.jck.travel.flight.util.enumeration;

public enum JourneyType {
    ONE_WAY(1),
    RETURN(2),
    MULTI_STOP(3),
    ADVANCE_SEARCH(4),
    PREMIUM_BUSINESS(5),
    SPECIAL_RETURN(6);

    private final int typeNo;

    JourneyType(int typeNo) {
        this.typeNo = typeNo;
    }

    public int getTypeNo() {
        return typeNo;
    }
}