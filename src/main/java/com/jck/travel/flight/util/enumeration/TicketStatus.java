package com.jck.travel.flight.util.enumeration;

public enum TicketStatus {

    FAILED(0),
    SUCCESSFUL(1),
    NOT_SAVED(2),
    NOT_CREATED(3),
    NOT_ALLOWED(4),
    IN_PROGRESS(5),
    TICKET_ALREADY_CREATED(6),
    PRICE_CHANGED(8),
    OTHER_ERROR(9),
    STATUS_ERROR(-1);

    private int statusCode;

    TicketStatus(final int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public static TicketStatus getStatus(int statusCode) {
        if (statusCode == 0)
            return TicketStatus.FAILED;
        if (statusCode == 1)
            return TicketStatus.SUCCESSFUL;
        if (statusCode == 2)
            return TicketStatus.NOT_SAVED;
        if (statusCode == 3)
            return TicketStatus.NOT_CREATED;
        if (statusCode == 4)
            return TicketStatus.NOT_ALLOWED;
        if (statusCode == 5)
            return TicketStatus.IN_PROGRESS;
        if (statusCode == 6)
            return TicketStatus.TICKET_ALREADY_CREATED;
        if (statusCode == 8)
            return TicketStatus.PRICE_CHANGED;
        if (statusCode == 9)
            return TicketStatus.OTHER_ERROR;
        else
            return TicketStatus.STATUS_ERROR;
    }

    public static TicketStatus from(String status) {
        if (status.equalsIgnoreCase("FAILED")) {
            return TicketStatus.FAILED;
        } else if (status.equalsIgnoreCase("SUCCESSFUL")) {
            return TicketStatus.SUCCESSFUL;
        } else if (status.equalsIgnoreCase("NOT_SAVED")) {
            return TicketStatus.NOT_SAVED;
        } else if (status.equalsIgnoreCase("NOT_CREATED")) {
            return TicketStatus.NOT_CREATED;
        } else if (status.equalsIgnoreCase("NOT_ALLOWED")) {
            return TicketStatus.NOT_ALLOWED;
        } else if (status.equalsIgnoreCase("IN_PROGRESS")) {
            return TicketStatus.IN_PROGRESS;
        } else if (status.equalsIgnoreCase("TICKET_ALREADY_CREATED")) {
            return TicketStatus.TICKET_ALREADY_CREATED;
        } else if (status.equalsIgnoreCase("PRICE_CHANGED")) {
            return TicketStatus.PRICE_CHANGED;
        } else if (status.equalsIgnoreCase("OTHER_ERROR")) {
            return TicketStatus.OTHER_ERROR;

        } else {
            return TicketStatus.STATUS_ERROR;
        }
    }
}