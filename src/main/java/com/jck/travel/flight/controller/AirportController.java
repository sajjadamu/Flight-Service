package com.jck.travel.flight.controller;

import com.jck.travel.flight.domain.Airport;
import com.jck.travel.flight.domain.City;
import com.jck.travel.flight.model.Response;
import com.jck.travel.flight.service.AirportService;
import com.jck.travel.flight.util.enumeration.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/rest/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @RequestMapping(value = "/search/{key}", method = RequestMethod.GET, consumes = "application/json")
    public Response getSearchAirport(@PathVariable("key") String key) {

        List<Object> airLineList = new ArrayList<>();
        List<Airport> airports = new ArrayList<>();

        List<Map<String, Object>> airportViewListFromAirport = getAirportViewList(airportService.getAirport(key));

        if (airportViewListFromAirport.size() != 0)
            airLineList.addAll(airportViewListFromAirport);

        for (City city : airportService.getCity(key)) {
            Airport airport = airportService.getAirportByCityId(city);
            if (airport != null)
                airports.add(airport);
        }
        List<Map<String, Object>> airportViewListFromCity = this.getAirportViewList(airports);

        if (airportViewListFromCity.size() != 0)
            airLineList.addAll(airportViewListFromCity);
        List<Object> airportList = airLineList.stream().distinct().collect(Collectors.toList());

        return Response.setSuccessResponse(Status.OK, null, airportList);
    }

    private List<Map<String, Object>> getAirportViewList(List<Airport> airports) {
        List<Map<String, Object>> airlineList = new ArrayList<>();

        for (Airport airport : airports) {
            Map<String, Object> airlineObject = new HashMap<>();
            airlineObject.put("key", airport.getAirportCode());

            Map<String, String> objectDetails = new HashMap<>();
            objectDetails.put("city", airport.getCity().getCityName());
            objectDetails.put("country", airport.getCity().getCountry().getCountryName());
            objectDetails.put("airportName", airport.getAirportName());
            airlineObject.put("value", objectDetails);
            airlineList.add(airlineObject);
        }
        return airlineList;
    }
}
