package com.jck.travel.flight.search.service.impl;

import com.jck.travel.flight.search.service.AuthenticationService;
import com.jck.travel.flight.util.service.impl.FlightRequestServiceImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("authenticationService")
public class AuthenticationServiceImpl extends FlightRequestServiceImpl implements AuthenticationService {

    @Override
    public JSONObject authenticate(String url, Map<String, ?> queryParams) throws JSONException {
        return new JSONObject(this.sendHttpPostRequest(url, queryParams).toString());
    }
}
