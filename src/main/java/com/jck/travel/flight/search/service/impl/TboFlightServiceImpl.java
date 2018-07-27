package com.jck.travel.flight.search.service.impl;

import com.jck.travel.flight.search.service.FlightService;
import com.jck.travel.flight.util.service.impl.FlightRequestServiceImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;

@Service("tboFlightService")
public class TboFlightServiceImpl extends FlightRequestServiceImpl implements FlightService {

    @Value("http://192.168.1.113:8080/users/validateToken")
    private String loginPath;

    @Override
    public boolean isAuthenticated(String token) throws JSONException, HttpClientErrorException {
        ResponseEntity status = this.sendHttpHeaderWithNoBody(loginPath, token);
        return ((status.getStatusCodeValue() == 200) && (status.hasBody()));
    }

    @Override
    public JSONObject getAvailabilityList(String url, Map<String, ?> queryParams) throws JSONException {
        return new JSONObject(this.sendHttpPostRequest(url, queryParams).toString());
    }
}
