package com.jck.travel.flight.service.impl;

import com.jck.travel.flight.model.Response;
import com.jck.travel.flight.service.SessionService;
import com.jck.travel.flight.util.enumeration.ApiTag;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("sessionService")
public class SessionServiceImpl implements SessionService {

    private Map<String, Map<String, Object>> sessionTokens = new HashMap<>();

    private Map<String, Response> sessionData = new HashMap<>();


    @Override
    public Map<String, Map<String, Object>> getAllTokens() {
        return sessionTokens;
    }

    @Override
    public Map<String, Object> getApiTokens(String cacheToken) {
        return sessionTokens.get(cacheToken);
    }

    @Override
    public boolean hasToken(String cacheToken) {
        return sessionTokens.containsKey(cacheToken);
    }

    @Override
    public void removeToken(String oldCacheToken, Map<String, Object> tokens) {
        sessionTokens.remove(oldCacheToken, tokens);
    }

    @Override
    public void setToken(String cacheToken, Map<String, Object> tokens) {
        sessionTokens.put(cacheToken, tokens);
    }

    @Override
    public Map<String, Response> getAllSessions() {
        return sessionData;
    }

    @Override
    public Response getSession(String cacheKey) {
        return sessionData.get(cacheKey);
    }

    @Override
    public void setSession(String cacheKey, Response dataToBeCache) {
        sessionData.put(cacheKey, dataToBeCache);
    }

    public void cacheTokens(String oldToken, String token, Object tokenToBeCache, ApiTag tag) {
        if (hasToken(oldToken)) {
            Map<String, Object> tokens = getApiTokens(oldToken);
            tokens.put(tag.getTag(), tokenToBeCache);
            removeToken(oldToken, tokens);
            setToken(token, tokens);
        } else {
            Map<String, Object> tokens = new HashMap<>();
            tokens.put(tag.getTag(), tokenToBeCache);
            setToken(token, tokens);
        }
    }

    public void cacheData(String token, Response dataToBeCache) {
        setSession(token, dataToBeCache);
    }
}
