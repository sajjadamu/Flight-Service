package com.jck.travel.flight.util.enumeration;

import javax.validation.constraints.NotNull;

public enum Status {
    OK(200),
    NOT_ACCEPTABLE(406),
    BAD_REQUEST(400),
    GATEWAY_TIMEOUT(504),
    SERVICE_UNAVAILABLE(503),
    INTERNAL_SERVER_ERROR(500),
    UNAUTHORIZED(401);

    private final int code;

    Status(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String toString() {
        return String.valueOf(code);
    }

    public static Status getStatus(int code) throws IllegalAccessError {
        if (code == 200)
            return Status.OK;
        else if (code == 406)
            return Status.NOT_ACCEPTABLE;
        else if (code == 400)
            return Status.BAD_REQUEST;
        else
            throw new IllegalAccessError("Status not found in Status Enum");
    }

    public boolean equals(@NotNull Status status) {
        return (status.getCode() == this.getCode());
    }
}
