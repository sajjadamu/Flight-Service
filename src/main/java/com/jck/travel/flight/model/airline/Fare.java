package com.jck.travel.flight.model.airline;


import java.util.Map;

public class Fare {

    private String id;

    private String fareCalculator; // For Galileo

    private Map<String, ?> baggageAllowance;

    private String totalFare;

    private String baseFare;

    private String totalTaxes;

    private String lastTicketingTime;

    private String pricingMethod;

    private String platingCarrier;

    private Map<String, ?> baggageAllowances;

    private FareBreakDown fareBreakDown;

    //private boolean negotiatedFare;

    //private String fareBasis;


    // private String effectiveDate;

    //private Map<String, ?> fareRuleKey;


    //private String approximateBasePrice;

    //private String approximateTaxes;

    // private String taxes;
}
