package com.jck.travel.flight.util.exception;


public class APITagNotFoundException extends Exception {
    private String message;

    public APITagNotFoundException() {
        super();
    }

    public APITagNotFoundException(String message) {
        super();
        this.message = message;
    }

    public APITagNotFoundException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
