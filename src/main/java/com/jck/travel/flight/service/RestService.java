package com.jck.travel.flight.service;

import com.jck.travel.flight.model.Error;
import com.jck.travel.flight.util.enumeration.Status;
import com.jck.travel.flight.util.exception.JSONResponseNotFoundException;
import org.json.JSONObject;

import java.util.Map;

public interface RestService {

    public JSONObject sendPostRequest(String url, Map<String, ?> queryParams);

    public JSONObject sendGetRequest(String url, Map<String, ?> queryParams);

    public void setResponse(JSONObject jsonResponse);

    public Status getHttpStatus() throws JSONResponseNotFoundException;

    public String getToken() throws JSONResponseNotFoundException;

    public Error getError() throws JSONResponseNotFoundException;

    public JSONObject getResponse() throws JSONResponseNotFoundException;
}
