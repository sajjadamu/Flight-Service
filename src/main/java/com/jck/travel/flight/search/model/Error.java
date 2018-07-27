package com.jck.travel.flight.search.model;

import java.io.Serializable;

public class Error implements Serializable {

    public int errorCode;
    public String errorMessage = "";

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static Error setPreDefinedError(int errorCode, String errorMessage) {
        Error error = new Error();
        error.setErrorCode(errorCode);
        error.setErrorMessage(errorMessage);
        return error;
    }

    public static Response setErrorResponse(String tokenId, int errorCode, String message) {
        Response response = new Response();
        response.setTokenId(tokenId);
        response.setError(setPreDefinedError(errorCode, message));
        return response;
    }
}


