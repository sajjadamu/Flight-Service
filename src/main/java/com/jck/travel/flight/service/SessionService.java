package com.jck.travel.flight.service;


import com.jck.travel.flight.model.Response;
import com.jck.travel.flight.util.enumeration.ApiTag;

import java.util.Map;

public interface SessionService {

    public Map<String, Map<String, Object>> getAllTokens();

    public Map<String, Object> getApiTokens(String cacheToken);

    public boolean hasToken(String cacheToken);

    public void removeToken(String oldCacheToken, Map<String, Object> tokens);

    public void setToken(String cacheToken, Map<String, Object> tokens);

    public Map<String, Response> getAllSessions();

    public Response getSession(String cacheKey);

    public void setSession(String cacheKey, Response dataToBeCache);

    public void cacheTokens(String oldToken, String token, Object tokenToBeCache, ApiTag tag);

    public void cacheData(String token, Response dataToBeCache);
}
