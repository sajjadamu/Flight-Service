package com.jck.travel.flight.util.enumeration;

public enum BookingStatus {
    NOT_SET(0),
    SUCCESSFUL(1),
    FAILED(2),
    OTHER_FARE(3),
    OTHER_CLASS(4),
    BOOKED_OTHER(5),
    NOT_CONFIRMED(6),
    STATUS_ERROR(-1);

    private int statusCode;

    BookingStatus(final int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public static BookingStatus getStatus(int statusCode) {

        if (statusCode == 0) {
            return BookingStatus.NOT_SET;
        } else if (statusCode == 1) {
            return BookingStatus.SUCCESSFUL;
        } else if (statusCode == 2) {
            return BookingStatus.FAILED;
        } else if (statusCode == 3) {
            return BookingStatus.OTHER_FARE;
        } else if (statusCode == 4) {
            return BookingStatus.OTHER_CLASS;
        } else if (statusCode == 5) {
            return BookingStatus.BOOKED_OTHER;
        } else if (statusCode == 6) {
            return BookingStatus.NOT_CONFIRMED;
        } else {
            return BookingStatus.STATUS_ERROR;
        }
    }

    public static BookingStatus from(String status) {
        if (status.equalsIgnoreCase("NOT_SET") || status.equalsIgnoreCase("NOT SET")) {
            return BookingStatus.NOT_SET;
        } else if (status.equalsIgnoreCase("SUCCESSFUL")) {
            return BookingStatus.SUCCESSFUL;
        } else if (status.equalsIgnoreCase("FAILED")) {
            return BookingStatus.FAILED;
        } else if (status.equalsIgnoreCase("OTHER FARE") || status.equalsIgnoreCase("OTHER_FARE")) {
            return BookingStatus.OTHER_FARE;
        } else if (status.equalsIgnoreCase("OTHER CLASS") || status.equalsIgnoreCase("OTHER_CLASS")) {
            return BookingStatus.OTHER_CLASS;
        } else if (status.equalsIgnoreCase("BOOKED OTHER") || status.equalsIgnoreCase("BOOKED_OTHER")) {
            return BookingStatus.BOOKED_OTHER;
        } else if (status.equalsIgnoreCase("NOT CONFIRMED") || status.equalsIgnoreCase("NOT_CONFIRMED")) {
            return BookingStatus.NOT_CONFIRMED;
        } else {
            return BookingStatus.STATUS_ERROR;
        }
    }

    @Override
    public String toString() {
        if (statusCode == 0) {
            return "NOT SET";
        } else if (statusCode == 1) {
            return "SUCCESSFUL";
        } else if (statusCode == 2) {
            return "FAILED";
        } else if (statusCode == 3) {
            return "OTHER FARE";
        } else if (statusCode == 4) {
            return "OTHER CLASS";
        } else if (statusCode == 5) {
            return "BOOKED OTHER";
        } else if (statusCode == 6) {
            return "NOT CONFIRMED";
        } else {
            return "STATUS ERROR";
        }
    }
}