package com.jck.travel.flight.search.model.co;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationCo {

    private String userIp;

    @NotNull
    @NotBlank
    private String tokenId; // given by the login API

    @NotNull
    @NotBlank
    private String username;

    private int sessionTimeOut;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSessionTimeOut() {
        return sessionTimeOut;
    }

    public Map<String, ?> getTboAuthRequest() {
        Map<String, Object> queryPrams = new HashMap<>();
        queryPrams.put("ClientId", "ApiIntegrationNew");
        queryPrams.put("UserName", "Justclick");

        queryPrams.put("Password", "Justclick@12");
        queryPrams.put("EndUserIp", userIp);
        return queryPrams;
    }
}
