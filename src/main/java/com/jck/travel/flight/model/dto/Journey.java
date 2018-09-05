package com.jck.travel.flight.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jck.travel.flight.model.dto.util.Searchable;
import com.jck.travel.flight.model.dto.util.Sortable;
import com.jck.travel.flight.util.enumeration.FlightSource;
import com.jck.travel.flight.util.enumeration.MealType;
import com.jck.travel.flight.util.enumeration.SourcePriority;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Journey implements Sortable<Flight>, Searchable<Flight> {

    private String id; // In TBO(ResultIndex), In Galileo(Key)

    private FlightSource source;

    //TODO Need to discuss
    private String baggage;

    //TODO Need to discuss
    private MealType mealType;

    private SourcePriority priority;

    private String origin;

    private String destination;

    @JsonIgnore
    private boolean isEnabled;

    private boolean isGSTMandatory;

    private boolean isGSTAllowed;

    private boolean isLCC;

    //TODO Need to discuss
    private BigInteger travelTime;

    private List<List<Segment>> segments = new ArrayList<>();

    private Fare fare;

    private List<FareRule> fareRules = new ArrayList<>();

    private List<FareBreakDown> fareBreakDowns = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FlightSource getSource() {
        return source;
    }

    public void setSource(FlightSource source) {
        this.source = source;
    }

    public String getBaggage() {
        return baggage;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public SourcePriority getPriority() {
        return priority;
    }

    public void setPriority(SourcePriority priority) {
        this.priority = priority;
    }

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

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public boolean isGSTMandatory() {
        return isGSTMandatory;
    }

    public void setGSTMandatory(boolean isGSTMandatory) {
        this.isGSTMandatory = isGSTMandatory;
    }

    public boolean isGSTAllowed() {
        return isGSTAllowed;
    }

    public void setGSTAllowed(boolean isGSTAllowed) {
        this.isGSTAllowed = isGSTAllowed;
    }

    public boolean isLCC() {
        return isLCC;
    }

    public void setLCC(boolean isLCC) {
        this.isLCC = isLCC;
    }

    public BigInteger getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(BigInteger travelTime) {
        this.travelTime = travelTime;
    }

    public List<List<Segment>> getSegments() {
        return segments;
    }

    public void setSegments(List<List<Segment>> segments) {
        this.segments = segments;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public List<FareRule> getFareRules() {
        return fareRules;
    }

    public void setFareRules(List<FareRule> fareRules) {
        this.fareRules = fareRules;
    }

    public List<FareBreakDown> getFareBreakDowns() {
        return fareBreakDowns;
    }

    public void setFareBreakDowns(List<FareBreakDown> fareBreakDowns) {
        this.fareBreakDowns = fareBreakDowns;
    }

    @Override
    public int compareTo(Flight object) {
        return 0;
    }

    @Override
    public int compare(Flight object1, Flight object2) {
        return 0;
    }

    @Override
    public boolean equals(Object object) {
        return false;
    }

}