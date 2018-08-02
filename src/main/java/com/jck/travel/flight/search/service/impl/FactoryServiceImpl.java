package com.jck.travel.flight.search.service.impl;

import com.jck.travel.flight.search.model.Response;
import com.jck.travel.flight.search.model.co.FilterCo;
import com.jck.travel.flight.search.service.FactoryService;
import com.jck.travel.flight.search.service.SessionService;
import com.jck.travel.flight.util.enumeration.ApiTag;
import com.jck.travel.flight.util.enumeration.DepartTime;
import com.jck.travel.flight.util.enumeration.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.*;

@Service("dataBindingService")
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class FactoryServiceImpl implements FactoryService {

    @Autowired
    private SessionService sessionService;

    @Override
    public Response filterBy_(FilterCo filterCo, Response dataForFilter) throws JSONException, ParseException {
        JSONObject jsonData = new JSONObject((HashMap) dataForFilter.getResponse());
        JSONArray jsonResult = jsonData.getJSONArray("results");

        Set<Set<?>> filteredData = new LinkedHashSet<>();
        for (int k = 0; k < jsonResult.length(); k++) {
            Set<JSONObject> innerFilteredData = new LinkedHashSet<>();

            for (int i = 0; i < jsonResult.getJSONArray(k).length(); i++) {
                JSONObject indexObj = jsonResult.getJSONArray(k).getJSONObject(i);

                // Price filter
                Double offeredFare = indexObj.getJSONObject("Fare").getDouble("OfferedFare");
                int min = Double.compare(offeredFare, Double.valueOf(filterCo.getMinimumPrice().toString()));
                int max = Double.compare(offeredFare, Double.valueOf(filterCo.getMaximumPrice().toString()));

                // Airline Filter
                if (filterCo.getAirLines().contains(indexObj.getString("AirlineCode"))) {
                    innerFilteredData.add(indexObj);
                } else if ((min == 0 || min > 0) && (max == 0 || max < 0)) {
                    innerFilteredData.add(indexObj);
                }
                // Refundable Or Non-Refundable filter
                else if (String.valueOf(indexObj.getBoolean("IsRefundable")).equalsIgnoreCase(filterCo.getIsRefundable().toString())) {
                    innerFilteredData.add(indexObj);
                } else {
                    //Depart Time filter
                    JSONArray segments = indexObj.getJSONArray("Segments").getJSONArray(0);
                    for (int j = 0; j < segments.length(); j++) {
                        DepartTime departTime = FilterCo.getDepartTimeByDate(segments.getJSONObject(j).getJSONObject("Origin").get("DepTime"));
                        if (filterCo.getDepartTime().equals(departTime.getTime()))
                            innerFilteredData.add(indexObj);
                    }
                }
            }
            filteredData.add(innerFilteredData);
        }

        JSONObject responseObj = new JSONObject();
        responseObj.put("destination", jsonData.getString("destination"));
        responseObj.put("origin", jsonData.getString("origin"));
        responseObj.put("results", filteredData);
        return Response.setSuccessResponse(Status.OK, filterCo.getTokenId(), responseObj.toMap());
    }

    @Override
    public Response getCacheData(String tokenKey) {
        return sessionService.getSession(tokenKey);
    }

    @Override
    public String verifyToken(String token) {
        if (sessionService.hasToken(token))
            return UUID.randomUUID().toString();
        else
            return null;
    }

    @Override
    public String verifyAuth(String token) throws HttpClientErrorException {
        /*if (tboFlightService.isAuthenticated(token))
            return UUID.randomUUID().toString();
        else
            return null;*/
        return null;
    }

    private String getCacheToken(@NotNull String cacheTokenKey, ApiTag tag) {
        Map<String, ?> tokens = sessionService.getApiTokens(cacheTokenKey);
        return String.valueOf(tokens.get(tag.getTag()));
    }
}