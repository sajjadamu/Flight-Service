package com.jck.travel.flight.search.service;

import com.jck.travel.flight.search.model.Response;
import com.jck.travel.flight.search.model.co.AuthenticationCo;
import com.jck.travel.flight.search.model.co.FilterCo;
import com.jck.travel.flight.search.model.co.SearchCo;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.HttpClientErrorException;

import java.text.ParseException;
import java.util.List;

public interface FactoryService {

    public Response bindAuth(List<JSONObject> objects, String oldToken, String token);

    public Response bindSearch(List<JSONObject> objects, String oldToken, String token);

    public List<JSONObject> getAuthentications(AuthenticationCo params);

    public List<JSONObject> getSearchAvailabilities(SearchCo searchCo) throws ParseException;

    public Response filterBy_(FilterCo filterCo, Response dataForFilter) throws JSONException, ParseException;

    public String verifyToken(String token);

    public String verifyAuth(String token) throws HttpClientErrorException;

    public Response getCacheData(String tokenKey);
}
