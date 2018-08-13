package com.jck.travel.flight.service;

import com.jck.travel.flight.model.Response;
import com.jck.travel.flight.util.exception.BadRequestException;
import com.jck.travel.flight.util.exception.JSONResponseNotFoundException;

import java.util.Map;

public interface RedisClientService {

    public boolean isValid(String token) throws JSONResponseNotFoundException, BadRequestException;

    public Response getBucket(String token) throws JSONResponseNotFoundException;

    public Map<String, ?> getBucket() throws JSONResponseNotFoundException;

    public Response setBucket(Map<String, ?> queryDat) throws JSONResponseNotFoundException;

    public String setBucket(String token, Map<String, ?> queryData);

    public boolean deleteBucket(String bucketKey, String key);

    public Map<String, ?> cacheTokenRequest(String token, Map<String, ?> data);
}
