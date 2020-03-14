package com.jck.travel.flight.model.co.booking_engine;

import org.json.JSONObject;

public class FareRuleCo {

    private String origin;

    private String destination;

    private String fareBasisCode;

    private String fareRuleDetail;

    private String fareRestriction;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFareBasisCode() {
        return fareBasisCode;
    }

    public void setFareBasisCode(String fareBasisCode) {
        this.fareBasisCode = fareBasisCode;
    }

    public String getFareRuleDetail() {
        return fareRuleDetail;
    }

    public void setFareRuleDetail(String fareRuleDetail) {
        this.fareRuleDetail = fareRuleDetail;
    }

    public String getFareRestriction() {
        return fareRestriction;
    }

    public void setFareRestriction(String fareRestriction) {
        this.fareRestriction = fareRestriction;
    }

    public void setRequest(JSONObject fareRule) {
        this.setOrigin(fareRule.getString("origin"));
        this.setDestination(fareRule.getString("destination"));
        this.setFareBasisCode(fareRule.getString("fareBasisCode"));

        if (fareRule.has("fareRuleDetail") && !fareRule.isNull("fareRuleDetail"))
            this.setFareRuleDetail(fareRule.getString("fareRuleDetail"));
        else
            this.setFareRuleDetail(null);

        if (fareRule.has("fareRestriction") && !fareRule.isNull("fareRestriction"))
            this.setFareRestriction(fareRule.getString("fareRestriction"));
        else
            this.setFareRestriction(null);
    }
}
