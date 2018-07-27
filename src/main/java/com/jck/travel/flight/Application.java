package com.jck.travel.flight;


import com.jck.travel.flight.util.component.DataBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
@ComponentScan
public class Application extends SpringBootServletInitializer {

    @Bean
    public DataBinding getBindProperties() throws IOException {
        DataBinding bind = new DataBinding();
        bind.loadProperties();
        return bind;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

