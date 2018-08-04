package com.jck.travel.flight.service;

import com.jck.travel.flight.util.exception.AuthenticationException;
import org.json.JSONObject;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface AuthenticationService {

    public boolean isAuthorised(String username, String token) throws AuthenticationException;

    public boolean isAuthorised(String token) throws AuthenticationException;

    public boolean isAuthorised(HttpServletRequest request) throws AuthenticationException;

    public Map<String, String> getUserCredentials(HttpServletRequest request) throws AuthenticationException;

    public boolean isValidRequestHeaders(HttpServletRequest request);

    public List<Map<String, String>> getHeaders(HttpServletRequest request);

    public ServletOutputStream sendErrorResponse(HttpServletResponse response, int httpErrorCode, JSONObject error) throws IOException;
}
