package com.jck.travel.flight.util.exception;

public class SearchAlreadyExistException extends Exception {
    private String message;

    public SearchAlreadyExistException() {
        super();
    }

    public SearchAlreadyExistException(String message) {
        super();
        this.message = message;
    }

    public SearchAlreadyExistException(Throwable cause) {
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
