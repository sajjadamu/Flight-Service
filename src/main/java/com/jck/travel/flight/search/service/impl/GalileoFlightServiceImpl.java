package com.jck.travel.flight.search.service.impl;

import com.jck.travel.flight.search.service.FlightService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("galileoFlightService")
public class GalileoFlightServiceImpl implements FlightService {

    @Override
    public boolean isAuthenticated(String token) throws JSONException {
        return false;
    }

    @Override
    public JSONObject getAvailabilityList(String url, Map<String, ?> queryParams) throws JSONException {
        System.out.println("==== Galileo Flight Service Demo =====");
        return null;
    }
}
