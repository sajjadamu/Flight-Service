package com.jck.travel.flight.util.enumeration;

import javax.validation.constraints.NotNull;

public enum Status {
    OK(200),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    NOT_ACCEPTABLE(406),
    CONFLICT(409),
    INTERNAL_SERVER_ERROR(500),
    SERVICE_UNAVAILABLE(503),
    GATEWAY_TIMEOUT(504);

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
        else if (code == 401)
            return Status.UNAUTHORIZED;
        else if (code == 409)
            return Status.CONFLICT;
        else if (code == 500)
            return Status.INTERNAL_SERVER_ERROR;
        else if (code == 503)
            return Status.SERVICE_UNAVAILABLE;
        else
            throw new IllegalAccessError("Status not found in Status Enum");
    }

    public boolean equals(@NotNull Status status) {
        return (status.getCode() == this.getCode());
    }
}
