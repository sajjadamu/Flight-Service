package com.jck.travel.flight.search.service.impl;

import com.jck.travel.flight.search.model.Response;
import com.jck.travel.flight.search.service.SerializeService;
import com.jck.travel.flight.util.enumeration.Status;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service("serializeService")
public class SerializeServiceImpl implements SerializeService {

    @Value("/home/yatin/TripZolo")
    private String path;

    @Value(".sch")
    private String fileExtension;

    public void save(Serializable writableObject, String searchName, String username) throws IOException {
        FileOutputStream writer = new FileOutputStream(new File(getSearchPath(searchName, username)));
        ObjectOutputStream bufferedWriter = new ObjectOutputStream(writer);
        bufferedWriter.writeObject(writableObject);
        bufferedWriter.close();
        writer.close();
    }

    public boolean isExist(String searchName, String username) throws IOException {
        return new File(getSearchPath(searchName, username)).exists();
    }

    public String getSearchPath(String searchName, String username) {
        return this.path + "/" + searchName + "_" + username + this.fileExtension;
    }

    public Response getSearch(String searchName, String username) throws IOException, ClassNotFoundException {
        File file = new File(getSearchPath(searchName, username));
        Map<String, Object> search = new LinkedHashMap<>();
        search.put(searchName, getSearch(file).getResponse());
        return Response.setSuccessResponse(Status.OK, null, search);
    }

    public Response getAllSearchKeys(String username) throws IOException, ClassNotFoundException {
        List<File> files = fileExists(username);
        List<String> searches = new LinkedList<>();

        for (File file : files) {
            searches.add(getSearchName(file.getName()));
        }
        return Response.setSuccessResponse(Status.OK, null, searches);
    }

    private Response getSearch(File file) throws IOException, ClassNotFoundException {
        FileInputStream fileReader = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileReader);
        Response object = (Response) objectInputStream.readObject();
        objectInputStream.close();
        fileReader.close();
        return object;
    }

    private String getSearchName(String fileName) {
        return fileName.split("_")[0];
    }

    private List<File> fileExists(String username) throws IOException {

        File[] files = new File(this.path).listFiles();
        List<File> existFiles = new LinkedList<>();

        if (files != null) {
            for (File file : files) {
                if (file.getName().contains(username)) {
                    existFiles.add(file);
                }
            }
        }
        return existFiles;
    }
}