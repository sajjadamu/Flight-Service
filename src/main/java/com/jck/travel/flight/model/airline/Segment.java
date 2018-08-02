package com.jck.travel.flight.model.airline;


import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class Segment {

    private String id;

    private String tripIndicator;

    private String segmentIndicator;

    private String departureTime;

    private String arrivalTime;

    private String eTicketAbility;

    private BigInteger distance;

    private boolean linkAvailability;

    private String origin;

    private String destination;

    private String equipment;

    private String availabilitySource;

    private String polledAvailabilityOption;

    private String flightNumber;

    private BigInteger flightTime;

    private String carrier;

    private String participantLevel;

    private boolean changeOfPlane;

    private boolean optionalServicesIndicator;

    private String availabilityDisplayType;

    private List<String> airProviders;

    private int group;

    public Segment(Map<String, ?> segment) {
 /*       "flightDetailsRef":[{
            "key":"QkMUNT7Q2BKAz95LCAAAAA=="
        }],
        "airAvailInfo":[{
            "providerCode":"1G"
        }],*/


        this.id = segment.get("key").toString();
        this.departureTime = segment.get("departureTime").toString();
        this.eTicketAbility = segment.get("eTicketability").toString();
        this.distance = BigInteger.valueOf(Long.valueOf(segment.get("distance").toString()));
        //this.linkAvailability = Boolean.valueOf(segment.get("linkAvailability").toString());
        this.origin = segment.get("origin").toString();
        this.destination = segment.get("destination").toString();
        this.equipment = segment.get("equipment").toString();
        this.availabilitySource = segment.get("availabilitySource").toString();
        this.polledAvailabilityOption = segment.get("polledAvailabilityOption").toString();
        this.flightNumber = segment.get("flightNumber").toString();
        this.carrier = segment.get("carrier").toString();
        this.participantLevel = segment.get("participantLevel").toString();
        this.changeOfPlane = Boolean.getBoolean(segment.get("changeOfPlane").toString());
        this.optionalServicesIndicator = Boolean.getBoolean(segment.get("optionalServicesIndicator").toString());
        this.participantLevel = segment.get("participantLevel").toString();
        this.arrivalTime = segment.get("arrivalTime").toString();
        this.flightTime = BigInteger.valueOf(Long.valueOf(segment.get("flightTime").toString()));
        this.availabilityDisplayType = segment.get("availabilityDisplayType").toString();
        this.group = Integer.parseInt(segment.get("group").toString());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String geteTicketAbility() {
        return eTicketAbility;
    }

    public void seteTicketAbility(String eTicketAbility) {
        this.eTicketAbility = eTicketAbility;
    }

    public BigInteger getDistance() {
        return distance;
    }

    public void setDistance(BigInteger distance) {
        this.distance = distance;
    }

    public boolean isLinkAvailability() {
        return linkAvailability;
    }

    public void setLinkAvailability(boolean linkAvailability) {
        this.linkAvailability = linkAvailability;
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

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getAvailabilitySource() {
        return availabilitySource;
    }

    public void setAvailabilitySource(String availabilitySource) {
        this.availabilitySource = availabilitySource;
    }

    public String getPolledAvailabilityOption() {
        return polledAvailabilityOption;
    }

    public void setPolledAvailabilityOption(String polledAvailabilityOption) {
        this.polledAvailabilityOption = polledAvailabilityOption;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public BigInteger getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(BigInteger flightTime) {
        this.flightTime = flightTime;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getParticipantLevel() {
        return participantLevel;
    }

    public void setParticipantLevel(String participantLevel) {
        this.participantLevel = participantLevel;
    }

    public boolean getChangeOfPlane() {
        return changeOfPlane;
    }

    public void setChangeOfPlane(boolean changeOfPlane) {
        this.changeOfPlane = changeOfPlane;
    }

    public boolean isOptionalServicesIndicator() {
        return optionalServicesIndicator;
    }

    public void setOptionalServicesIndicator(boolean optionalServicesIndicator) {
        this.optionalServicesIndicator = optionalServicesIndicator;
    }

    public String getAvailabilityDisplayType() {
        return availabilityDisplayType;
    }

    public void setAvailabilityDisplayType(String availabilityDisplayType) {
        this.availabilityDisplayType = availabilityDisplayType;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public List<String> getAirProviders() {
        return airProviders;
    }

    public void setAirProviders(List<String> airProviders) {
        this.airProviders = airProviders;
    }
}