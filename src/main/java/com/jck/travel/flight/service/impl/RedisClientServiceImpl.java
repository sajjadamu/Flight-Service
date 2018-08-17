package com.jck.travel.flight.service.impl;

import com.jck.travel.flight.config.ApplicationConfig;
import com.jck.travel.flight.model.Response;
import com.jck.travel.flight.service.RedisClientService;
import com.jck.travel.flight.service.RestService;
import com.jck.travel.flight.util.enumeration.Status;
import com.jck.travel.flight.util.exception.BadRequestException;
import com.jck.travel.flight.util.exception.JSONResponseNotFoundException;
import com.jck.travel.flight.util.exception.ServiceBlockerFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service("redisClientService")
public class RedisClientServiceImpl implements RedisClientService {

    @Autowired
    private RestService restService;

    @Autowired
    private ApplicationConfig config;

    @Override
    public boolean isValid(String token) throws JSONResponseNotFoundException, BadRequestException, ServiceBlockerFoundException {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("token", token);

        restService.setResponse(restService.sendPostRequest(config.getApiVerificationPath(), params));
        if (restService.getHttpStatus().equals(Status.OK)) {
            return restService.getResponse().getBoolean("isAuthorised");
        } else {
            if (restService.getHttpStatus().equals(Status.BAD_REQUEST))
                throw new BadRequestException("Bad request for token verification");
            else
                return false;
        }
    }

    @Override
    public Response getBucket(String token) throws JSONResponseNotFoundException, ServiceBlockerFoundException {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("token", token);

        restService.setResponse(restService.sendGetRequest(config.getRedisTokenCachePath(), params));
        if (restService.getHttpStatus().equals(Status.OK)) {
            List<Object> objects = restService.getResponse().getJSONArray("response").toList();
            return Response.setSuccessResponse(Status.OK, null, objects);
        } else {
            return Response.setErrorResponse(restService.getHttpStatus(), null, restService.getError());
        }
    }

    @Override
    public Map<String, ?> getBucket() throws JSONResponseNotFoundException {
        /*restService.setResponse(restService.sendGetRequest(config.getRedisTokenCachePath()));

        if (restService.getHttpStatus().equals(Status.OK)) {
            return Response.setSuccessResponse(Status.OK, null, restService.getResponse().toMap());
        } else {
            return Response.setErrorResponse(restService.getHttpStatus(), null, restService.getError());
        }*/
        return null;
    }

    @Override
    public Response setBucket(Map<String, ?> queryData) throws JSONResponseNotFoundException, ServiceBlockerFoundException {
        restService.setResponse(restService.sendPostRequest(config.getRedisTokenCachePath(), queryData));
        if (restService.getHttpStatus().equals(Status.OK)) {
            return Response.setSuccessResponse(Status.OK, null, restService.getResponse().toMap());
        } else {
            return Response.setErrorResponse(restService.getHttpStatus(), null, restService.getError());
        }
    }

    @Override
    public String setBucket(String token, Map<String, ?> queryData) {
        return null;
    }

    @Override
    public boolean deleteBucket(String bucketKey, String key) {
        return false;
    }

    @Override
    public Map<String, ?> cacheTokenRequest(String token, Map<String, ?> data) {
        Map<String, Object> request = new LinkedHashMap<>();
        request.put("token", token);
        request.put("data", data);
        return request;
    }
}
