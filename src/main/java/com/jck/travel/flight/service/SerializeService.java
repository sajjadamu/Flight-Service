package com.jck.travel.flight.service;

import com.jck.travel.flight.model.Response;

import java.io.IOException;
import java.io.Serializable;

public interface SerializeService {

    public void save(Serializable writableObject, String searchName, String username) throws IOException;

    public String getSearchPath(String searchName, String username);

    public boolean isExist(String searchName, String username) throws IOException;

    public Response getSearch(String searchName, String username) throws IOException, ClassNotFoundException;

    public Response getAllSearchKeys(String username) throws IOException, ClassNotFoundException;
}
