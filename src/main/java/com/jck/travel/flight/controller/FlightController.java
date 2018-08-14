package com.jck.travel.flight.controller;

import com.jck.travel.flight.model.Error;
import com.jck.travel.flight.model.Response;
import com.jck.travel.flight.model.co.FareRuleCo;
import com.jck.travel.flight.model.co.FilterCo;
import com.jck.travel.flight.model.co.SearchCo;
import com.jck.travel.flight.service.FactoryService;
import com.jck.travel.flight.service.SerializeService;
import com.jck.travel.flight.service.impl.AbstractRequestUtil;
import com.jck.travel.flight.util.enumeration.ErrorCode;
import com.jck.travel.flight.util.exception.AuthenticationException;
import com.jck.travel.flight.util.exception.BadRequestException;
import com.jck.travel.flight.util.exception.JSONResponseNotFoundException;
import com.jck.travel.flight.util.exception.SearchAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

@CrossOrigin
@RestController
@RequestMapping("/rest/flight")
public class FlightController {

    @Autowired
    private FactoryService factoryService;

    @Autowired
    private SerializeService serializeService;


    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = "application/json")
    public Response search(@RequestBody @Valid SearchCo searchCo, BindingResult bindingResult, HttpServletRequest request) throws IOException, NoSuchAlgorithmException, ParseException, AuthenticationException, BadRequestException, JSONResponseNotFoundException {
        searchCo.setUserIp(AbstractRequestUtil.getClientIpAddress(request));

        if (bindingResult.hasErrors() && !searchCo.validateSegments()) {
            request.setAttribute("errorResponse", Error.setErrorResponse(searchCo.getTokenId(), ErrorCode.BAD_REQUEST.getCode(), "Bad Request"));
            throw new BadRequestException("Bad Request. Params missing");
        }

        if (!searchCo.validatePassengerCount()) {
            request.setAttribute("errorResponse", Error.setErrorResponse(searchCo.getTokenId(), ErrorCode.BAD_REQUEST.getCode(), "Adult, Child & Infant count must be in valid range"));
            throw new BadRequestException("Bad Request. Passenger Count fail");
        }

        return factoryService.getSearch(searchCo);
    }

    @RequestMapping(value = "/fare_rule", method = RequestMethod.POST, consumes = "application/json")
    public Response fareRule(@RequestBody @Valid FareRuleCo fareRuleCo, BindingResult bindingResult, HttpServletRequest request) throws BadRequestException, ParseException, JSONResponseNotFoundException {

        fareRuleCo.setTokenId(String.valueOf(request.getAttribute("credentials")));
        if (bindingResult.hasErrors()) {
            request.setAttribute("errorResponse", Error.setErrorResponse(fareRuleCo.getTokenId(), ErrorCode.BAD_REQUEST.getCode(), "Bad Request"));
            throw new BadRequestException("Bad Request. Params missing");
        }

        return factoryService.getFareRule(fareRuleCo);
    }

    @RequestMapping(value = "/filter/price", method = RequestMethod.GET, consumes = "application/json")
    public Response filterByPrice(@Valid FilterCo filterCo, HttpServletRequest request) throws ParseException, AuthenticationException {
        verify(filterCo.getTokenId(), request);

        filterCo.setDefaultFilters();
        return factoryService.filterBy_(filterCo, factoryService.getCacheData(filterCo.getTokenId()));
    }

    @RequestMapping(value = "/filter/depart_time", method = RequestMethod.GET, consumes = "application/json")
    public Response filterByDepartTime(@Valid FilterCo filterCo, HttpServletRequest request) throws ParseException, AuthenticationException {
        verify(filterCo.getTokenId(), request);

        filterCo.setDefaultFilters();
        return factoryService.filterBy_(filterCo, factoryService.getCacheData(filterCo.getTokenId()));
    }

    @RequestMapping(value = "/filter/fare_type", method = RequestMethod.GET, consumes = "application/json")
    public Response filterByFareType(@Valid FilterCo filterCo, HttpServletRequest request) throws ParseException, AuthenticationException {
        verify(filterCo.getTokenId(), request);

        filterCo.setDefaultFilters();
        return factoryService.filterBy_(filterCo, factoryService.getCacheData(filterCo.getTokenId()));
    }

    @RequestMapping(value = "/filter/airline", method = RequestMethod.GET, consumes = "application/json")
    public Response filterByAirLines(@Valid FilterCo filterCo, HttpServletRequest request) throws ParseException, AuthenticationException {
        verify(filterCo.getTokenId(), request);

        filterCo.setDefaultFilters();
        return factoryService.filterBy_(filterCo, factoryService.getCacheData(filterCo.getTokenId()));
    }

    @RequestMapping(value = "/save_search/{key}/{username}/{token}", method = RequestMethod.GET, consumes = "application/json")
    public Response saveSearch(@PathVariable("key") String searchKey, @PathVariable("username") String username, @PathVariable("token") String token, HttpServletRequest request) throws IOException, SearchAlreadyExistException, BadRequestException, ClassNotFoundException {

        if (searchKey != null && !searchKey.isEmpty()) {

            if (!serializeService.isExist(searchKey, username)) {

                Response response = factoryService.getCacheData(token);
                serializeService.save(response, searchKey, username);
                return serializeService.getAllSearchKeys(username);
            } else {
                throw new SearchAlreadyExistException("Search already exists with this name");
            }
        } else {
            request.setAttribute("errorResponse", Error.setErrorResponse(token, ErrorCode.BAD_REQUEST.getCode(), "Bad Request"));
            throw new BadRequestException("Bad Request. Params missing");
        }
    }

    @RequestMapping(value = "/search_list/{key}/{username}/{token}", method = RequestMethod.GET, produces = "application/json")
    public Response getSavedSearch(@PathVariable("key") String key, @PathVariable("username") String username, @PathVariable("token") String token, HttpServletRequest request) throws IOException, ClassNotFoundException {
        return serializeService.getSearch(key, username);
    }

    private String verify(String tokenId, HttpServletRequest request) throws AuthenticationException {
        String token = factoryService.verifyToken(tokenId);
        if (token == null) {
            request.setAttribute("errorResponse", Error.setErrorResponse(null, ErrorCode.UNAUTHORIZED.getCode(), "Authentication Fail."));
            throw new AuthenticationException("Authentication Fail.");
        }
        return token;
    }
}