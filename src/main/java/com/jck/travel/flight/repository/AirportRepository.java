package com.jck.travel.flight.repository;

import com.jck.travel.flight.domain.Airport;
import com.jck.travel.flight.domain.City;

import java.util.List;

public interface AirportRepository {

    public List<Airport> getAirport(String cityCodeName);

    public List<City> getCity(String cityCodeName);

    public Airport getAirportByCityId(City city);

}

