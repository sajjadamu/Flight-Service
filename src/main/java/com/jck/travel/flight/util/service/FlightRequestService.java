package com.jck.travel.flight.util.service;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;

public interface FlightRequestService {

    public Object sendHttpPostRequest(String url, Map<String, ?> queryParams);

    public Object sendHttpGetRequest(String url, Map<String, ?> queryParams);

    public Object sendHttpHeaderWithNoBody(String url, String token) throws HttpClientErrorException;

    public JSONObject getJSONObject() throws JSONException;

    public JSONArray getJSONArray() throws JSONException;
}
