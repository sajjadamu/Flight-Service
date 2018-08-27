package com.jck.travel.flight.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration("config")
public class ApplicationConfig {

    @Value("${jck.flight.search.path}")
    private String jckSearchPath;

    @Value("${auth.verification.path}")
    private String authVerificationPath;

    @Value("${jck.api.verification.path}")
    private String apiVerificationPath;

    @Value("${tbo.service.search.path}")
    private String tboSearchPath;

    @Value("${tbo.service.fare.rule.path}")
    private String tboFareRulePath;

    @Value("${tbo.service.fare.quote.path}")
    private String tboFareQuotePath;

    @Value("${tbo.service.booking.holding.path}")
    private String tboBookingHoldingPath;

    @Value("${tbo.service.flight.ticket.path}")
    private String tboFlightTicketPath;

    @Value("${booking.engine.service.flight.ticket.path}")
    private String saveTicketPath;

    @Value("${booking.engine.service.flight.booking.holding.path}")
    private String pnrHoldingPath;

    @Value("${redis.service.token.cache}")
    private String redisTokenCachePath;

    public String getSaveTicketPath() {
        return saveTicketPath;
    }

    public String getPnrHoldingPath() {
        return pnrHoldingPath;
    }

    public String getTboFlightTicketPath() {
        return tboFlightTicketPath;
    }

    public String getTboBookingHoldingPath() {
        return tboBookingHoldingPath;
    }

    public String getTboFareQuotePath() {
        return tboFareQuotePath;
    }

    public String getApiVerificationPath() {
        return apiVerificationPath;
    }

    public String getJckSearchPath() {
        return jckSearchPath;
    }

    public String getRedisTokenCachePath() {
        return redisTokenCachePath;
    }

    public String getTboFareRulePath() {
        return tboFareRulePath;
    }

    public String getTboSearchPath() {
        return tboSearchPath;
    }

    public String getAuthVerificationPath() {
        return authVerificationPath;
    }
}
