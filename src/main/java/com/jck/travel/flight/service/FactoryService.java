package com.jck.travel.flight.service;

import com.jck.travel.flight.model.Response;
import com.jck.travel.flight.model.co.FilterCo;
import com.jck.travel.flight.model.co.SearchCo;
import com.jck.travel.flight.util.exception.JSONResponseNotFoundException;
import com.jck.travel.flight.util.exception.ServiceBlockerFoundException;
import org.json.JSONException;

import java.text.ParseException;

public interface FactoryService extends TBOService, GalileoService {

    public Response getSearch(SearchCo searchCo) throws ParseException, JSONResponseNotFoundException, ServiceBlockerFoundException;

    public Response filterBy_(FilterCo filterCo, Response dataForFilter) throws JSONException, ParseException;

    public String verifyToken(String token);

    public Response getCacheData(String tokenKey);
}
