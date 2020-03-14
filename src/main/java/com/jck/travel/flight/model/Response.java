package com.jck.travel.flight.model;

import com.jck.travel.flight.util.enumeration.Status;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Response<T> implements Serializable {

    private int status;
    private Error error;
    private String tokenId;
    private T response;

    public int getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status.getCode();
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public static Response setSuccessResponse(Status status, String tokenId, Map<String, Object> responseObj) {
        Response<Map<String, Object>> response = new Response<>();
        response.setStatus(status);
        response.setError(new Error());
        response.setTokenId(tokenId);
        response.setResponse(responseObj);
        return response;
    }

    public static Response setSuccessResponse(Status status, String tokenId, List<?> responseObj) {
        Response<List<?>> response = new Response<>();
        response.setStatus(status);
        response.setError(new Error());
        response.setTokenId(tokenId);
        response.setResponse(responseObj);
        return response;
    }

    public static Response setErrorResponse(String tokenId, @NotNull Error error) {
        Response response = new Response();
        response.setTokenId(tokenId);
        response.setError(error);
        return response;
    }

    public static Response setErrorResponse(Status status, String tokenId, @NotNull Error error) {
        Response response = new Response();
        response.setStatus(status);
        response.setTokenId(tokenId);
        response.setError(error);
        return response;
    }
}
