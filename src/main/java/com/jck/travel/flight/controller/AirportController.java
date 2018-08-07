package com.jck.travel.flight.controller;

import com.jck.travel.flight.domain.Airport;
import com.jck.travel.flight.domain.City;
import com.jck.travel.flight.model.Response;
import com.jck.travel.flight.service.AirportService;
import com.jck.travel.flight.util.enumeration.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @RequestMapping(value = "/search_airport/{key}", method = RequestMethod.GET, consumes = "application/json")
    public Response getSearchAirport(@PathVariable("key") String key) {

        List<Object> airLineList = new ArrayList<>();
        List<Airport> airports = new ArrayList<>();

        List<Map<String, String>> airportViewListFromAirport = getAirportViewList(airportService.getAirport(key));

        if (airportViewListFromAirport.size() != 0)
            airLineList.addAll(airportViewListFromAirport);

        for (City city : airportService.getCity(key)) {
            Airport airport = airportService.getAirportByCityId(city);
            if (airport != null)
                airports.add(airport);
        }
        List<Map<String, String>> airportViewListFromCity = this.getAirportViewList(airports);

        if (airportViewListFromCity.size() != 0)
            airLineList.addAll(airportViewListFromCity);
        List<Object> airportList = airLineList.stream().distinct().collect(Collectors.toList());

        return Response.setSuccessResponse(Status.OK, null, airportList);
    }

    private List<Map<String, String>> getAirportViewList(List<Airport> airports) {
        List<Map<String, String>> airLineList = new ArrayList<>();

        for (Airport airport : airports) {
            Map<String, String> airLineObject = new HashMap<>();
            airLineObject.put(airport.getAirportCode(), airport.getCity().getCityName() + " (" + airport.getAirportCode() + ") " + airport.getCity().getCountry().getCountryName() + " <br> " + airport.getAirportName());
            airLineList.add(airLineObject);
        }
        return airLineList;
    }
}
