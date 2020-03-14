package com.jck.travel.flight.config;


import com.jck.travel.flight.domain.Airport;
import com.jck.travel.flight.domain.City;
import com.jck.travel.flight.domain.Country;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.IOException;
import java.util.Properties;

public class PersistenceUnit {

    private StandardServiceRegistryBuilder registryBuilder;
    private SessionFactory sessionFactory;
    private MetadataSources metadataSources;

    public PersistenceUnit() throws IOException {
        registryBuilder = new StandardServiceRegistryBuilder();
        registryBuilder.applySettings(loadProperties());
        addMetadata();
        buildSessionFactory();
    }

    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("hibernate.properties"));
        return properties;
    }

    private void addMetadata() {
        metadataSources = new MetadataSources(registryBuilder.build());
        metadataSources.addPackage("com.jck.travel.flight.domain");
        metadataSources.addAnnotatedClass(Airport.class);
        metadataSources.addAnnotatedClass(City.class);
        metadataSources.addAnnotatedClass(Country.class);

    }

    private void buildSessionFactory() {
        Metadata metadata = metadataSources.getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}