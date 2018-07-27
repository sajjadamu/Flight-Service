package com.jck.travel.flight.util.service.impl;

import com.google.gson.Gson;
import com.jck.travel.flight.util.service.FlightRequestService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public abstract class FlightRequestServiceImpl implements FlightRequestService {

    private static final String[] IP_HEADER_CANDIDATES = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"};

    public Object sendHttpPostRequest(String url, Map<String, ?> queryParams) throws HttpClientErrorException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new RestTemplate().postForObject(url, new HttpEntity<>(new Gson().toJson(queryParams), headers), String.class);
    }

    @Override
    public Object sendHttpGetRequest(String url, Map<String, ?> queryParams) {
        return null;
    }

    @Override
    public ResponseEntity sendHttpHeaderWithNoBody(String url, String token) throws HttpClientErrorException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, token);
        return new RestTemplate().exchange(url, HttpMethod.GET, new HttpEntity<>(headers), Boolean.class);
    }

    @Override
    public JSONObject getJSONObject() throws JSONException {
        return null;
    }

    @Override
    public JSONArray getJSONArray() throws JSONException {
        return null;
    }

    public static String getClientIpAddress(HttpServletRequest request) {
        for (String header : IP_HEADER_CANDIDATES) {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }
        return request.getRemoteAddr();
    }
}
