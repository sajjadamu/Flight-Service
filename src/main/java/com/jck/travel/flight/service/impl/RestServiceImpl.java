package com.jck.travel.flight.service.impl;

import com.google.gson.Gson;
import com.jck.travel.flight.model.Error;
import com.jck.travel.flight.service.RestService;
import com.jck.travel.flight.util.enumeration.Status;
import com.jck.travel.flight.util.exception.JSONResponseNotFoundException;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

@Service("restService")
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
public class RestServiceImpl implements RestService {

    private JSONObject jsonResponse;

    public JSONObject getJsonResponse() {
        return jsonResponse;
    }

    @Override
    public JSONObject sendPostRequest(String url, Map<String, ?> queryParams) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new JSONObject(new RestTemplate().postForObject(url, new HttpEntity<>(new Gson().toJson(queryParams), headers), String.class));
    }

    @Override
    public JSONObject sendGetRequest(String url, Map<String, ?> queryParams) {
        return null;
    }

    @Override
    public Status getHttpStatus() throws JSONResponseNotFoundException {
        if (jsonResponse == null)
            throw new JSONResponseNotFoundException("JSONResponseNotFoundException : JSON response is not set yet, May be NULL");

        return Status.getStatus(jsonResponse.getInt("status"));
    }

    @Override
    public String getToken() throws JSONResponseNotFoundException {
        if (jsonResponse == null)
            throw new JSONResponseNotFoundException("JSONResponseNotFoundException : JSON response is not set yet, May be NULL");

        return jsonResponse.getString("tokenId");
    }

    @Override
    public Error getError() throws JSONResponseNotFoundException {
        if (jsonResponse == null)
            throw new JSONResponseNotFoundException("JSONResponseNotFoundException : JSON response is not set yet, May be NULL");

        JSONObject error = jsonResponse.getJSONObject("error");
        return Error.setPreDefinedError(error.getInt("errorCode"), error.getString("errorMessage"));
    }

    @Override
    public JSONObject getResponse() throws JSONResponseNotFoundException {
        if (jsonResponse == null)
            throw new JSONResponseNotFoundException("JSONResponseNotFoundException : JSON response is not set yet, May be NULL");

        return jsonResponse.getJSONObject("response");
    }

    @Override
    public void setResponse(JSONObject jsonResponse) {
        this.jsonResponse = jsonResponse;
    }
}
