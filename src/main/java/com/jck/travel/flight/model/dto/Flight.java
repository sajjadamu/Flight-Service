package com.jck.travel.flight.model.dto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jck.travel.flight.model.dto.util.Searchable;
import com.jck.travel.flight.model.dto.util.Sortable;
import com.jck.travel.flight.util.enumeration.FlightSource;
import com.jck.travel.flight.util.enumeration.SourcePriority;

public class Flight implements Sortable<Flight>, Searchable<Flight> {

	private String id; // In TBO(ResultIndex), In Galileo(Key)

	private String duration;

	private String price;

	private FlightSource source;

	private String baggage;

	private boolean isMeal;

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBaggage() {
		return baggage;
	}

	public void setBaggage(String baggage) {
		this.baggage = baggage;
	}

	public boolean isMeal() {
		return isMeal;
	}

	public void setMeal(boolean isMeal) {
		this.isMeal = isMeal;
	}

	public void setFareRules(List<FareRule> fareRules) {
		this.fareRules = fareRules;
	}

	public void setFareBreakDowns(List<FareBreakDown> fareBreakDowns) {
		this.fareBreakDowns = fareBreakDowns;
	}

	private SourcePriority priority;

	@JsonIgnore
	private boolean isEnabled;

	private boolean isRefundable;

	private boolean isGSTMandatory;

	private boolean isGSTAllowed;

	private boolean isLCC;

	private BigInteger travelTime;

	private String airLineCode;

	private String airLineName;

	private List<List<Segment>> segments = new ArrayList<>();

	private Fare fares;

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

	public SourcePriority getPriority() {
		return priority;
	}

	public void setPriority(SourcePriority priority) {
		this.priority = priority;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public boolean isRefundable() {
		return isRefundable;
	}

	public void setRefundable(boolean isRefundable) {
		this.isRefundable = isRefundable;
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

	public String getAirLineCode() {
		return airLineCode;
	}

	public void setAirLineCode(String airLineCode) {
		this.airLineCode = airLineCode;
	}

	public String getAirLineName() {
		return airLineName;
	}

	public void setAirLineName(String airLineName) {
		this.airLineName = airLineName;
	}

	public void setSegments(List<Segment> segment) {
		if (segment != null)
			this.segments.add(segment);
	}

	public Fare getFares() {
		return fares;
	}

	public void setFares(Fare fares) {
		this.fares = fares;
	}

	public List<FareRule> getFareRules() {
		return fareRules;
	}

	public void setFareRules(FareRule fareRule) {
		if (fareRule != null)
			this.fareRules.add(fareRule);
	}

	public List<FareBreakDown> getFareBreakDowns() {
		return fareBreakDowns;
	}

	public void setFareBreakDowns(FareBreakDown fareBreakDown) {
		if (fareBreakDown != null)
			this.fareBreakDowns.add(fareBreakDown);
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
