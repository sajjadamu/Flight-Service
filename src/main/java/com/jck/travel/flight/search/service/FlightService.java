package com.jck.travel.flight.search.service;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;

public interface FlightService {

    public boolean isAuthenticated(String token) throws JSONException, HttpClientErrorException;

    public JSONObject getAvailabilityList(String url, Map<String, ?> queryParams) throws JSONException;
}
