package com.jck.travel.flight.service.impl;

import com.google.gson.Gson;
import com.jck.travel.flight.config.ApplicationConfig;
import com.jck.travel.flight.model.Error;
import com.jck.travel.flight.model.Response;
import com.jck.travel.flight.model.co.*;
import com.jck.travel.flight.model.dto.util.ModelBindingUtil;
import com.jck.travel.flight.service.FactoryService;
import com.jck.travel.flight.service.RedisClientService;
import com.jck.travel.flight.service.RestService;
import com.jck.travel.flight.util.enumeration.DepartTime;
import com.jck.travel.flight.util.enumeration.Status;
import com.jck.travel.flight.util.exception.JSONResponseNotFoundException;
import com.jck.travel.flight.util.exception.ServiceBlockerFoundException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service("factoryService")
public class FactoryServiceImpl extends ModelBindingUtil implements FactoryService {

    @Autowired
    private RestService restService;

    @Autowired
    private RedisClientService redisClientService;

    @Autowired
    private ApplicationConfig config;

    @Override
    public Response getSearch(SearchCo searchCo) throws ParseException, JSONResponseNotFoundException, ServiceBlockerFoundException {
        restService.setResponse(restService.sendPostRequest(config.getTboSearchPath(), searchCo.getTboServiceRequest()));

        if (restService.getHttpStatus().equals(Status.OK)) {
            JSONObject response = restService.getResponse();

            Map<String, String> data = new LinkedHashMap<>();
            data.put("tokenId", restService.getToken());
            data.put("traceId", response.getString("traceId"));

            //TODO Need to pass auth token for verification on Redis Service
            Response responseRedis = redisClientService.setBucket(redisClientService.cacheTokenRequest("TOKEN", data));

            if (responseRedis.getStatus() == Status.OK.getCode()) {
                JSONObject json = new JSONObject(new Gson().toJson(responseRedis.getResponse()));
                return Response.setSuccessResponse(Status.OK, json.getString("token"), super.getResponse(response));
            } else {
                return responseRedis;
            }
        } else {
            return Response.setErrorResponse(restService.getHttpStatus(), null, restService.getError());
        }
    }

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
    public String verifyToken(String token) {
        return null;
    }

    @Override
    public Response getCacheData(String tokenKey) {
        return null;
    }

    @Override
    public Response getFareRule(FareRuleCo fareRuleCo) throws ParseException, JSONResponseNotFoundException, ServiceBlockerFoundException {
        Response response = redisClientService.getBucket(fareRuleCo.getTokenId());
        List jsonArray = (List) response.getResponse();

        if (jsonArray.size() == 1) {
            Map jsonObject = (Map) jsonArray.get(0);

            if (jsonObject.get("tokenId") == null || jsonObject.get("traceId") == null) {
                return Response.setErrorResponse(Status.NOT_ACCEPTABLE, fareRuleCo.getTokenId(), Error.setPreDefinedError(Status.NOT_ACCEPTABLE.getCode(), "Search not found"));
            }

            restService.setResponse(restService.sendPostRequest(config.getTboFareRulePath(), fareRuleCo.getTboServiceRequest(String.valueOf(jsonObject.get("tokenId")), String.valueOf(jsonObject.get("traceId")))));

            if (restService.getHttpStatus().equals(Status.OK)) {
                return Response.setSuccessResponse(Status.OK, fareRuleCo.getTokenId(), super.getFareRuleResponse(restService.getResponse().getJSONArray("fareRules")));
            } else {
                return Response.setErrorResponse(restService.getHttpStatus(), fareRuleCo.getTokenId(), restService.getError());
            }
        } else
            return Response.setErrorResponse(Status.NOT_ACCEPTABLE, fareRuleCo.getTokenId(), Error.setPreDefinedError(Status.NOT_ACCEPTABLE.getCode(), "Search not found"));
    }

    @Override
    public Response getFareQuote(FareQuoteCo fareQuoteCo) throws ParseException, JSONResponseNotFoundException, ServiceBlockerFoundException {
        Response response = redisClientService.getBucket(fareQuoteCo.getTokenId());
        List jsonArray = (List) response.getResponse();

        if (jsonArray.size() == 1) {
            Map jsonObject = (Map) jsonArray.get(0);

            if (jsonObject.get("tokenId") == null || jsonObject.get("traceId") == null) {
                return Response.setErrorResponse(Status.NOT_ACCEPTABLE, fareQuoteCo.getTokenId(), Error.setPreDefinedError(Status.NOT_ACCEPTABLE.getCode(), "Search not found"));
            }

            restService.setResponse(restService.sendPostRequest(config.getTboFareQuotePath(), fareQuoteCo.getTboServiceRequest(String.valueOf(jsonObject.get("tokenId")), String.valueOf(jsonObject.get("traceId")))));

            if (restService.getHttpStatus().equals(Status.OK)) {
                JSONObject object = restService.getResponse();
                return Response.setSuccessResponse(Status.OK, fareQuoteCo.getTokenId(), super.getFareQuoteResponse(object.getBoolean("isPriceChanged"), object.getJSONObject("results")));
            } else {
                return Response.setErrorResponse(restService.getHttpStatus(), fareQuoteCo.getTokenId(), restService.getError());
            }
        } else
            return Response.setErrorResponse(Status.NOT_ACCEPTABLE, fareQuoteCo.getTokenId(), Error.setPreDefinedError(Status.NOT_ACCEPTABLE.getCode(), "Search not found"));
    }

    @Override
    public Response makeBooking(BookingCo bookingCo) throws ParseException, JSONResponseNotFoundException {
        return null;
    }
}