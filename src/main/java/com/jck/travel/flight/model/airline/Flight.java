package com.jck.travel.flight.model.airline;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jck.travel.flight.util.enumeration.FlightSource;
import com.jck.travel.flight.util.enumeration.SourcePriority;

import java.util.ArrayList;
import java.util.List;

public class Flight {

    private String id;

    private FlightSource source;

    private SourcePriority priority;

    @JsonIgnore
    private boolean isEnabled;

    private boolean isRefundable;

    private boolean isGSTMandatory;

    private boolean isGSTAllowed;

    private boolean isLCC;

    private String airLineCode;

    private String airLineName;

    private List<Segment> segments = new ArrayList<>();

    private List<Fare> fares;

    private List<FareRule> fareRules;

    private List<FareBreakDown> fareBreakDowns = new ArrayList<>();
}
