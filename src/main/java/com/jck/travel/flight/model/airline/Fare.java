package com.jck.travel.flight.model.airline;


import java.util.List;
import java.util.Map;

public class Fare {

    private String id;

    private String amount;

    private Map<String, ?> notValidBefore;

    private Map<String, ?> baggageAllowance;

    private String origin;

    private String passengerTypeCode;

    private String destination;

    private boolean negotiatedFare;

    private String fareBasis;

    private Map<String, ?> notValidAfter;

    private Map<String, ?> departureDate;

    private String effectiveDate;

    private Map<String, ?> fareRuleKey;

    // Air Pricing Solution Object
    private String approximateTotalPrice;

    private String totalPrice;

    private String approximateBasePrice;

    private String approximateTaxes;

    private String taxes;

    //airPricingInfo object
    private List<Map<String, ?>> fareBreakDown;

    private String basePrice;
}
