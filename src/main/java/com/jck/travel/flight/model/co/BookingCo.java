package com.jck.travel.flight.model.co;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookingCo {

    private String tokenId;

    @NotBlank
    @NotNull
    private String id;

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
        params.put("tokenId", tokenId);
        params.put("traceId", traceId);
        params.put("resultIndex", this.id);
        return params;
    }
}
