package com.jck.travel.flight.search.service;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public interface AuthenticationService {

    public JSONObject authenticate(String url, Map<String, ?> queryParams) throws JSONException;
}
