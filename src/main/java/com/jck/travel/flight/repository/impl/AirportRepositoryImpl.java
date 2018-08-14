package com.jck.travel.flight.repository.impl;

import com.jck.travel.flight.domain.Airport;
import com.jck.travel.flight.domain.City;
import com.jck.travel.flight.repository.AirportRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository("airportRepository")
public class AirportRepositoryImpl implements AirportRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Airport> getAirport(String cityNameCode) {
        Session session = sessionFactory.getCurrentSession();
        List<Airport> airports = new ArrayList<>();
        session.beginTransaction();
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Airport> criteria = builder.createQuery(Airport.class);
            Root<Airport> root = criteria.from(Airport.class);
            criteria.select(root).where(builder.or(builder.like(root.<String>get("airportCode"),
                    cityNameCode + "%"), builder.like(root.<String>get("airportName"), cityNameCode + "%")));
            airports = session.createQuery(criteria).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return airports;
    }

    @Override
    public List<City> getCity(String cityCodeName) {
        Session session = sessionFactory.getCurrentSession();
        List<City> cityList = new ArrayList<>();
        session.beginTransaction();
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<City> criteria = builder.createQuery(City.class);
            Root<City> root = criteria.from(City.class);
            criteria.select(root).where(builder.or(builder.like(root.<String>get("cityCode"),
                    cityCodeName + "%"), builder.like(root.<String>get("cityName"), cityCodeName + "%")));
            cityList = session.createQuery(criteria).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cityList;
    }


    @Override
    public Airport getAirportByCityId(City city) {
        Session session = sessionFactory.getCurrentSession();
        Airport airport = new Airport();
        session.beginTransaction();
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Airport> criteria = builder.createQuery(Airport.class);
            Root<Airport> root = criteria.from(Airport.class);
            criteria.select(root).where(builder.equal(root.get("city"), city));
            airport = session.createQuery(criteria).getSingleResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
        return airport;
    }
}
