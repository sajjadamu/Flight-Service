package com.jck.travel.flight.util.enumeration;

public enum Gender {
    MALE(1),
    FEMALE(2),
    NOT_FOUND(0);

    private int gender;

    Gender(final int gender) {
        this.gender = gender;
    }

    public int getCode() {
        return this.gender;
    }

    @Override
    public String toString() {
        if (this.getCode() == 1)
            return "Male";
        else if (this.getCode() == 2)
            return "Female";
        else
            return null;
    }

    public static Gender from(String gender) {
        if (gender.equalsIgnoreCase("male"))
            return Gender.MALE;
        else if (gender.equalsIgnoreCase("female"))
            return Gender.FEMALE;
        else
            return Gender.NOT_FOUND;
    }
}
