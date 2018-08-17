package com.jck.travel.flight.service;

import com.jck.travel.flight.model.Error;
import com.jck.travel.flight.util.enumeration.Status;
import com.jck.travel.flight.util.exception.JSONResponseNotFoundException;
import com.jck.travel.flight.util.exception.ServiceBlockerFoundException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface RestService {

    public JSONObject sendPostRequest(String url, Map<String, ?> queryParams) throws ServiceBlockerFoundException;

    public ResponseEntity<String> sendGetRequest(String url, Map<String, ?> queryParams) throws ServiceBlockerFoundException;

    public ResponseEntity<String> sendGetRequest(String url) throws ServiceBlockerFoundException;

    public void setResponse(JSONObject jsonResponse);

    public void setResponse(ResponseEntity<String> jsonResponse);

    public Status getHttpStatus() throws JSONResponseNotFoundException;

    public String getToken() throws JSONResponseNotFoundException;

    public Error getError() throws JSONResponseNotFoundException;

    public JSONObject getResponse() throws JSONResponseNotFoundException;
}
