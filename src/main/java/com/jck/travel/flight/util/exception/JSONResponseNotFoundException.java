package com.jck.travel.flight.util.exception;

public class JSONResponseNotFoundException extends Exception {
    private String message;

    public JSONResponseNotFoundException() {
        super();
    }

    public JSONResponseNotFoundException(String message) {
        super();
        this.message = message;
    }

    public JSONResponseNotFoundException(Throwable cause) {
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
