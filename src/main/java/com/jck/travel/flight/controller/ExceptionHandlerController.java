package com.jck.travel.flight.controller;

import com.jck.travel.flight.model.Error;
import com.jck.travel.flight.model.Response;
import com.jck.travel.flight.util.enumeration.ErrorCode;
import com.jck.travel.flight.util.enumeration.Status;
import com.jck.travel.flight.util.exception.AuthenticationException;
import com.jck.travel.flight.util.exception.BadRequestException;
import com.jck.travel.flight.util.exception.JSONResponseNotFoundException;
import com.jck.travel.flight.util.exception.SearchAlreadyExistException;
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
    public Response jsonException(HttpServletRequest request) {
        return (Response) request.getAttribute("errorResponse");
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public Response AuthException(HttpServletRequest request) {
        return (Response) request.getAttribute("errorResponse");
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public Response AuthAPIException(HttpServletRequest request) {
        return Error.setErrorResponse(null, ErrorCode.UNAUTHORIZED.getCode(), "Authentication Fail.");
    }

    @ExceptionHandler(SearchAlreadyExistException.class)
    @ResponseBody
    public Response SearchAlreadyExistException(HttpServletRequest request) {
        return Error.setErrorResponse(null, ErrorCode.NOT_ACCEPTABLE.getCode(), "Search already exists with this name.");
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public Response badRequestException(HttpServletRequest request) {
        Response response = (Response) request.getAttribute("errorResponse");
        response.setStatus(Status.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(IOException.class)
    @ResponseBody
    public Response IOException(HttpServletRequest request) {
        System.out.println("========IOException=============");
        return new Response();
    }

    @ExceptionHandler(ParseException.class)
    @ResponseBody
    public Response parseException(HttpServletRequest request) {
        System.out.println("========date parse flow=============");
        return new Response();
    }

    @ExceptionHandler(JSONResponseNotFoundException.class)
    @ResponseBody
    public Response jsonResponseNotFoundException(HttpServletRequest request) {
        System.out.println("========JSON Response Not Found Exception=============");
        return new Response();
    }

    @ExceptionHandler(ClassNotFoundException.class)
    @ResponseBody
    public Response ClassNotFoundException(HttpServletRequest request) {
        System.out.println("========ClassNotFoundException=============");
        return new Response();
    }
}
