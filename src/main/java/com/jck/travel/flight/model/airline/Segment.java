package com.jck.travel.flight.model.airline;


import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class Segment {

    private String id;

    private String departureTime;

    private String arrivalTime;

    private String eTicketAbility;

    private BigInteger distance;

    private String fareClass;

    private boolean linkAvailability;

    private String origin;

    private String destination;

    private String equipment; // craft in TBO

    private String availabilitySource;  // Need to get More Info

    private String tripIndicator;

    private String segmentIndicator;

    private String flightNumber;

    private BigInteger flightTime;

    private String carrier;

    private String polledAvailabilityOption; // Need to get More Info

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
}
