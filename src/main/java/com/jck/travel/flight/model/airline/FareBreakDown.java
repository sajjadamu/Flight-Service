package com.jck.travel.flight.model.airline;


import com.jck.travel.flight.util.enumeration.PaxType;

import java.util.Map;

public class FareBreakDown {

    private String totalPrice;

    private String basePrice;

    private TaxBreakUp taxBreakUp;

    private PaxType passengerType;

    private Map<String, ?> changePenalty;

    private Map<String, ?> cancelPenalty;
}
