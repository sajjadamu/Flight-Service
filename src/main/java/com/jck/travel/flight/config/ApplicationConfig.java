package com.jck.travel.flight.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration("config")
public class ApplicationConfig {

    @Value("${auth.verification.path}")
    private String authVerificationPath;

    @Value("${tbo.service.search.path}")
    private String tboSearchPath;

    public String getTboSearchPath() {
        return tboSearchPath;
    }

    public String getAuthVerificationPath() {
        return authVerificationPath;
    }
}
