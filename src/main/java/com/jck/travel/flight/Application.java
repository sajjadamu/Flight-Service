package com.jck.travel.flight;

import com.jck.travel.flight.config.PersistenceUnit;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@SpringBootApplication
@ComponentScan
@PropertySource(value = {"classpath:application.properties"})
public class Application extends SpringBootServletInitializer {

    @Bean
    public SessionFactory getSessionFactory() throws IOException {
        return new PersistenceUnit().getSessionFactory();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

