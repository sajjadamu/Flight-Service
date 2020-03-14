package com.jck.travel.flight.service.impl;

import com.jck.travel.flight.domain.Airport;
import com.jck.travel.flight.domain.City;
import com.jck.travel.flight.repository.AirportRepository;
import com.jck.travel.flight.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("airportService")
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<Airport> getAirport(String cityCodeName) {
        return airportRepository.getAirport(cityCodeName);
    }

    @Override
    public List<City> getCity(String cityCodeName) {
        return airportRepository.getCity(cityCodeName);
    }

    @Override
    public Airport getAirportByCityId(City city) {
        return airportRepository.getAirportByCityId(city);
    }
}
