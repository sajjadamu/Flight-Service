package com.jck.travel.flight.controller;

import com.jck.travel.flight.model.Error;
import com.jck.travel.flight.model.Response;
import com.jck.travel.flight.util.enumeration.ErrorCode;
import com.jck.travel.flight.util.enumeration.Status;
import com.jck.travel.flight.util.exception.*;
import org.json.JSONException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;

@CrossOrigin
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JSONException.class)
    @ResponseBody
    public Response jsonException(HttpServletRequest request, JSONException jsonEx) {
        if (jsonEx != null)
            jsonEx.printStackTrace();

        return (Response) request.getAttribute("errorResponse");
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public Response AuthException(HttpServletRequest request, AuthenticationException authEx) {
        if (authEx != null)
            authEx.printStackTrace();

        return (Response) request.getAttribute("errorResponse");
    }

    //TODO need to handle Status code of APIs
    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public Response AuthAPIException(HttpServletRequest request, HttpClientErrorException httpEx) {
        if (httpEx != null)
            httpEx.printStackTrace();

        return Error.setErrorResponse(null, ErrorCode.UNAUTHORIZED.getCode(), "Request processing getting failed.");
    }

    @ExceptionHandler(SearchAlreadyExistException.class)
    @ResponseBody
    public Response SearchAlreadyExistException(HttpServletRequest request) {
        return Error.setErrorResponse(null, ErrorCode.NOT_ACCEPTABLE.getCode(), "Search already exists with this name.");
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public Response badRequestException(HttpServletRequest request, BadRequestException badEx) {
        if (badEx != null)
            badEx.printStackTrace();

        Response response = (Response) request.getAttribute("errorResponse");
        response.setStatus(Status.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(IOException.class)
    @ResponseBody
    public Response IOException(HttpServletRequest request, IOException ioEx) {
        if (ioEx != null)
            ioEx.printStackTrace();

        return Response.setErrorResponse(Status.GATEWAY_TIMEOUT, null, Error.setPreDefinedError(Status.GATEWAY_TIMEOUT.getCode(), "Connection Error."));
    }

    @ExceptionHandler(ServiceBlockerFoundException.class)
    @ResponseBody
    public Response httpServerErrorException(ServiceBlockerFoundException ioEx) {
        if (ioEx != null)
            ioEx.printStackTrace();

        return Response.setErrorResponse(Status.INTERNAL_SERVER_ERROR, null, Error.setPreDefinedError(Status.INTERNAL_SERVER_ERROR.getCode(), "Service blocker found. Which breaks this functionality"));
    }

    @ExceptionHandler(ParseException.class)
    @ResponseBody
    public Response parseException(HttpServletRequest request, ParseException parseEx) {
        if (parseEx != null)
            parseEx.printStackTrace();

        return new Response();
    }

    @ExceptionHandler(JSONResponseNotFoundException.class)
    @ResponseBody
    public Response jsonResponseNotFoundException(HttpServletRequest request, JSONResponseNotFoundException jsonRespEx) {
        if (jsonRespEx != null)
            jsonRespEx.printStackTrace();

        return new Response();
    }

    @ExceptionHandler(ClassNotFoundException.class)
    @ResponseBody
    public Response ClassNotFoundException(HttpServletRequest request, ClassNotFoundException classNotEx) {
        if (classNotEx != null)
            classNotEx.printStackTrace();

        return new Response();
    }
}
