package com.jck.travel.flight.util.exception;

public class ServiceBlockerFoundException extends Exception {
    private String message;

    public ServiceBlockerFoundException() {
        super();
    }

    public ServiceBlockerFoundException(String message) {
        super();
        this.message = message;
    }

    public ServiceBlockerFoundException(Throwable cause) {
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
