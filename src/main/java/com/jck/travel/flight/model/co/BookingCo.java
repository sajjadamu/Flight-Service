package com.jck.travel.flight.model.co;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

public class BookingCo {

    private String tokenId;

    private String userIp;

    @NotBlank
    @NotNull
    private String id;

    @NotBlank
    @NotNull
    private String isLCC;

    @NotBlank
    @NotNull
    private String isMealRequired;

    @NotBlank
    @NotNull
    private String isSeatPrefRequired;

    @NotNull
    private List<PassengerCo> passengers = new ArrayList<>();

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public @NotBlank @NotNull String getIsLCC() {
        return isLCC;
    }

    public void setIsLCC(@NotBlank @NotNull String isLCC) {
        this.isLCC = isLCC;
    }

    public @NotBlank @NotNull String getIsMealRequired() {
        return isMealRequired;
    }

    public void setIsMealRequired(@NotBlank @NotNull String isMealRequired) {
        this.isMealRequired = isMealRequired;
    }

    public @NotBlank @NotNull String getIsSeatPrefRequired() {
        return isSeatPrefRequired;
    }

    public void setIsSeatPrefRequired(@NotBlank @NotNull String isSeatPrefRequired) {
        this.isSeatPrefRequired = isSeatPrefRequired;
    }

    public @NotNull List<PassengerCo> getPassengers() {
        return passengers;
    }

    public void setPassengers(@NotNull List<PassengerCo> passengers) {
        this.passengers = passengers;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, ?> getTboServiceRequest(String tokenId, String traceId) {
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("userIp", this.userIp);
        params.put("tokenId", tokenId);
        params.put("traceId", traceId);
        params.put("resultIndex", this.id);
        params.put("isLCC", this.isLCC);
        params.put("isMealRequired", this.isMealRequired);
        params.put("isSeatPrefRequired", this.isSeatPrefRequired);

        List<Map<String, ?>> passengers = new LinkedList<>();
        for (int i = 0; i < this.getPassengers().size(); i++) {
            passengers.add(this.getPassengers().get(i).getTboRequest(this.isLCC, this.isMealRequired, this.isSeatPrefRequired));
        }
        params.put("passengers", passengers);
        return params;
    }
}
