package com.jck.travel.flight.service.impl;

import com.google.gson.Gson;
import com.jck.travel.flight.model.Error;
import com.jck.travel.flight.service.RestService;
import com.jck.travel.flight.util.enumeration.Status;
import com.jck.travel.flight.util.exception.JSONResponseNotFoundException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service("restService")
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
public class RestServiceImpl implements RestService {

    private JSONObject jsonResponse;

    private ResponseEntity<String> responseEntity;

    public ResponseEntity<String> getResponseEntity() {
        return responseEntity;
    }

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
    public ResponseEntity<String> sendGetRequest(String url, Map<String, ?> queryParams) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        for (Map.Entry<String, ?> entry : queryParams.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new RestTemplate().exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<>(headers), String.class);
    }

    @Override
    public ResponseEntity<String> sendGetRequest(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new RestTemplate().exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);
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

        if (isArray(jsonResponse.opt("response"))) {
            JSONArray array = jsonResponse.getJSONArray("response");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("response", array);
            return jsonObject;
        } else
            return jsonResponse.getJSONObject("response");
    }

    @Override
    public void setResponse(ResponseEntity<String> jsonResponse) {
        this.responseEntity = jsonResponse;

        if (jsonResponse.getStatusCode().value() == 200) {
            this.jsonResponse = new JSONObject(jsonResponse.getBody());
        } else {
            // TODO need to test this condition
            JSONObject object = new JSONObject();
            object.put("status", jsonResponse.getStatusCode());
            this.jsonResponse = object;
        }
    }

    @Override
    public void setResponse(JSONObject jsonResponse) {
        this.jsonResponse = jsonResponse;
    }

    private boolean isArray(Object object) {
        return object != null && (object.toString().startsWith("[") && object.toString().endsWith("]"));
    }
}
