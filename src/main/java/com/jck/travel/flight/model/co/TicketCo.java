package com.jck.travel.flight.model.co;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

public class TicketCo {

    private String userIp;

    private String tokenId;

    @NotBlank
    @NotNull
    private String isLCC;

    private String PNR;

    private String bookingId;

    private String id;

    private List<PassengerCo> passengers = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<PassengerCo> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerCo> passengers) {
        this.passengers = passengers;
    }

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

    public @NotBlank @NotNull String getIsLCC() {
        return isLCC;
    }

    public void setIsLCC(@NotBlank @NotNull String isLCC) {
        this.isLCC = isLCC;
    }

    public boolean isValidTicketRequest() {
        if (this.isLCC.equalsIgnoreCase("true")) {
            return passengers.size() != 0 & this.id != null && !id.isEmpty();
        } else {
            return ((this.PNR != null && !this.PNR.isEmpty()) && (this.bookingId != null && !this.bookingId.isEmpty()));
        }
    }

    public Map<String, ?> getTboServiceRequest(String tokenId, String traceId) {
        Map<String, Object> params = new LinkedHashMap<>();

        params.put("userIp", this.userIp);
        params.put("tokenId", tokenId);
        params.put("traceId", traceId);
        params.put("isLCC", this.isLCC);

        if (this.isLCC.equalsIgnoreCase("true")) {
            params.put("resultIndex", this.id);
            List<Map<String, ?>> passengers = new LinkedList<>();
            for (int i = 0; i < this.getPassengers().size(); i++) {
                passengers.add(this.getPassengers().get(i).getTboRequest(this.isLCC, "false", "false"));
            }
            params.put("passengers", passengers);
        } else {
            params.put("pnr", this.PNR);
            params.put("bookingId", this.bookingId);
        }

        return params;
    }
}