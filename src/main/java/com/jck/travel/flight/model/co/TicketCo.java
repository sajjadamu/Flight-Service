package com.jck.travel.flight.model.co;

import java.util.LinkedHashMap;
import java.util.Map;

public class TicketCo {

    private String userIp;

    private String tokenId;

    private String PNR;

    private String bookingId;

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getPNR() {
        return PNR;
    }

    public void setPNR(String PNR) {
        this.PNR = PNR;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public Map<String, ?> getTboServiceRequest(String tokenId, String traceId) {
        Map<String, Object> params = new LinkedHashMap<>();

        params.put("userIp", this.userIp);
        params.put("tokenId", tokenId);
        params.put("traceId", traceId);
        params.put("pnr", this.PNR);
        params.put("bookingId", this.bookingId);

        return params;
    }
}