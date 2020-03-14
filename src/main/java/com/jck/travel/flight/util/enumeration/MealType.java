package com.jck.travel.flight.util.enumeration;

public enum MealType {

    FREE(0),
    PAID(1),
    NOT_DEFINED(2);

    private int type;

    MealType(final int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}