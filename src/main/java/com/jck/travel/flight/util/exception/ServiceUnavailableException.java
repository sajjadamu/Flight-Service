package com.jck.travel.flight.util.exception;

public class ServiceUnavailableException extends Exception {
    private String message;

    public ServiceUnavailableException() {
        super();
    }

    public ServiceUnavailableException(String message) {
        super();
        this.message = message;
    }

    public ServiceUnavailableException(Throwable cause) {
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
