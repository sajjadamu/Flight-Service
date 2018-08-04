package com.jck.travel.flight.service;

import com.jck.travel.flight.model.Response;
import com.jck.travel.flight.model.co.FilterCo;
import com.jck.travel.flight.model.co.SearchCo;
import com.jck.travel.flight.util.exception.JSONResponseNotFoundException;
import org.json.JSONException;
import org.springframework.web.client.HttpClientErrorException;

import java.text.ParseException;

public interface FactoryService {

    public Response getSearch(SearchCo searchCo) throws ParseException, JSONResponseNotFoundException;

    public Response filterBy_(FilterCo filterCo, Response dataForFilter) throws JSONException, ParseException;

    public String verifyToken(String token);

    public String verifyAuth(String token) throws HttpClientErrorException;

    public Response getCacheData(String tokenKey);
}
