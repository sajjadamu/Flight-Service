package com.jck.travel.flight.service.impl;

import com.jck.travel.flight.config.ApplicationConfig;
import com.jck.travel.flight.service.AuthenticationService;
import com.jck.travel.flight.util.exception.AuthenticationException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final String[] REQUEST_HEADERS = {"accept", "authorization", "content-type"};

    @Autowired
    private ApplicationConfig config;

    @Override
    public boolean isAuthorised(String username, String token) throws AuthenticationException {
        return checkAuthorization(username, token);
    }

    @Override
    public boolean isAuthorised(HttpServletRequest request) throws AuthenticationException {
        return checkAuthorization(getUserCredentials(request).get("username"), getUserCredentials(request).get("token"));
    }

    @Override
    public Map<String, String> getUserCredentials(HttpServletRequest request) throws AuthenticationException {
        List<Map<String, String>> headers = getHeaders(request);
        Map<String, String> authorizationHeader = new HashMap<>();

        for (Map<String, String> header : headers) {

            if (header.containsKey("Authorization") || header.containsKey("authorization")) {
                String authorizationValue = header.get("authorization");
                String AuthorizationValue = header.get("Authorization");

                if (AuthorizationValue != null) {
                    authorizationHeader = getCredentials(AuthorizationValue);
                }

                if (authorizationValue != null) {
                    authorizationHeader = getCredentials(authorizationValue);
                }
                break;
            }
        }
        return authorizationHeader;
    }

    @Override
    public boolean isValidRequestHeaders(HttpServletRequest request) {

        List<Boolean> status = new LinkedList<>();
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            for (String header : REQUEST_HEADERS) {
                if (header.equalsIgnoreCase(name))
                    status.add(true);
            }
        }
        return (!status.isEmpty() && status.size() == 3);
    }

    @Override
    public List<Map<String, String>> getHeaders(HttpServletRequest request) {
        List<Map<String, String>> headers = new LinkedList<>();
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            Map<String, String> header = new HashMap<>();
            String headerName = headerNames.nextElement();
            header.put(headerName, request.getHeader(headerName));
            headers.add(header);
        }
        return headers;
    }

    @Override
    public ServletOutputStream sendErrorResponse(HttpServletResponse response, int httpErrorCode, JSONObject error) throws IOException {
        response.setContentType(String.valueOf(MediaType.APPLICATION_JSON));
        response.setStatus(httpErrorCode);
        ServletOutputStream stream = response.getOutputStream();
        stream.write(error.toString().getBytes());
        return stream;
    }

    private ResponseEntity sendHttpHeaderWithNoBody(String url, String token) throws HttpClientErrorException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, token);
        return new RestTemplate().exchange(url, HttpMethod.GET, new HttpEntity<>(headers), Boolean.class);
    }

    private Map<String, String> getCredentials(@NotNull String authorization) throws AuthenticationException {
        Map<String, String> authorizationHeader = new HashMap<>();

        if (authorization == null || !authorization.startsWith("Basic")) {
            throw new AuthenticationException("AuthenticationException : Invalid User Credentials");
        }

        String base64Credentials = authorization.substring("Basic".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
        final String[] values = credentials.split(":", 2);

        if (values[0].trim().isEmpty() || values[1].trim().isEmpty()) {
            throw new AuthenticationException("AuthenticationException : Invalid User Credentials");
        }

        authorizationHeader.put("username", values[0]);
        authorizationHeader.put("token", values[1]);
        return authorizationHeader;
    }

    private boolean checkAuthorization(@NotNull String username, @NotNull String token) throws AuthenticationException {
        ResponseEntity status;

        try {
            status = this.sendHttpHeaderWithNoBody(config.getAuthVerificationPath(), token);

        } catch (HttpClientErrorException exp) {
            throw new AuthenticationException("AuthenticationException : Invalid User Credentials");
        }
        return ((status.getStatusCodeValue() == 200) && (status.hasBody()));
    }
}
