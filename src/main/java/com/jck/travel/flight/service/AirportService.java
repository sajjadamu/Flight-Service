package com.jck.travel.flight.service;

import com.jck.travel.flight.domain.Airport;
import com.jck.travel.flight.domain.City;

import java.util.List;

public interface AirportService {

    public List<Airport> getAirport(String airportCodeName);

    public List<City> getCity(String cityCodeName);

    public Airport getAirportByCityId(City city);

}
