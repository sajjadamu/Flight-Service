package com.jck.travel.flight.model.co;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SearchCo {

    private String userIp;

    @NotNull
    @NotBlank
    private String tokenId;

    @NotNull
    private Integer adultCount;

    @NotNull
    private Integer childCount;

    @NotNull
    private Integer infantCount;

    @NotNull
    private Boolean isDomestic;

    @NotNull
    private Boolean directFlight; //Optional

    @NotNull
    private Boolean oneStopFlight; //Optional

    @NotNull
    private String journeyType; // enum need create

    private List<String> preferredAirlines; //Optional

    @NotNull
    private List<Map<String, ?>> segments;

    @NotNull
    private List<String> sources; //Optional

    public @NotNull List<Map<String, ?>> getSegments() {
        return segments;
    }

    public void setSegments(@NotNull List<Map<String, ?>> segments) {
        this.segments = segments;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public @NotNull @NotBlank String getTokenId() {
        return tokenId;
    }

    public void setTokenId(@NotNull @NotBlank String tokenId) {
        this.tokenId = tokenId;
    }

    public Integer getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(Integer adultCount) {
        this.adultCount = adultCount;
    }

    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public Integer getInfantCount() {
        return infantCount;
    }

    public void setInfantCount(Integer infantCount) {
        this.infantCount = infantCount;
    }

    public Boolean getDirectFlight() {
        return directFlight;
    }

    public void setDirectFlight(Boolean directFlight) {
        this.directFlight = directFlight;
    }

    public Boolean getOneStopFlight() {
        return oneStopFlight;
    }

    public void setOneStopFlight(Boolean oneStopFlight) {
        this.oneStopFlight = oneStopFlight;
    }

    public String getJourneyType() {
        return journeyType;
    }

    public void setJourneyType(String journeyType) {
        this.journeyType = journeyType;
    }

    public List<String> getPreferredAirlines() {
        return preferredAirlines;
    }

    public void setPreferredAirlines(List<String> preferredAirlines) {
        this.preferredAirlines = preferredAirlines;
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public Boolean isDomestic() {
        return isDomestic;
    }

    public void setIsDomestic(Boolean isDomestic) {
        this.isDomestic = isDomestic;
    }

    public boolean validatePassengerCount() {
        return (this.adultCount >= 1 && this.childCount >= 0 && infantCount >= 0);
    }

    public boolean validateSegments() throws ParseException {
        List<Map<String, ?>> segments = this.getValidSegments();
        return (segments.size() >= 1);
    }

    public Map<String, ?> getTboServiceRequest() throws ParseException {
        Map<String, Object> tboMap = this.toMap();
        tboMap.put("tokenId", this.tokenId);
        return tboMap;
    }

    public Map<String, ?> getGalileoServiceRequest() throws ParseException {
        return new LinkedHashMap<>();
    }

    private List<Map<String, ?>> getValidSegments() throws ParseException {
        List<Map<String, ?>> segmentObjList = new LinkedList<>();

        for (Map<String, ?> co : this.segments) {
            Set<String> keys = co.keySet();

            if (keys.contains("origin") && keys.contains("destination") && keys.contains("flightCabinClass") && keys.contains("preferredArrivalTime")) {
                if ((co.get("origin") != null && !co.get("origin").toString().isEmpty()) && (co.get("destination") != null && !co.get("destination").toString().isEmpty()) && (co.get("flightCabinClass") != null && !co.get("flightCabinClass").toString().isEmpty()) && (co.get("preferredArrivalTime") != null && !co.get("preferredArrivalTime").toString().isEmpty()) && (co.get("preferredDepartureTime") != null && !co.get("preferredDepartureTime").toString().isEmpty())) {
                    Map<String, Object> segmentsObj = new HashMap<>();
                    segmentsObj.put("origin", co.get("origin"));
                    segmentsObj.put("destination", co.get("destination"));
                    segmentsObj.put("flightCabinClass", co.get("flightCabinClass").toString());
                    segmentsObj.put("preferredArrivalTime", parseTboDate(Long.valueOf(co.get("preferredArrivalTime").toString())));
                    segmentsObj.put("preferredDepartureTime", parseTboDate(Long.valueOf(co.get("preferredDepartureTime").toString())));
                    segmentObjList.add(segmentsObj);
                }
            }
        }
        return segmentObjList;
    }

    public Map<String, Object> toMap() throws ParseException {
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("endUserIp", this.userIp);
        params.put("isDomestic", this.isDomestic);
        params.put("adultCount", this.adultCount);
        params.put("childCount", this.childCount);
        params.put("infantCount", this.infantCount);
        params.put("directFlight", this.directFlight);
        params.put("oneStopFlight", this.oneStopFlight);
        params.put("journeyType", this.journeyType);
        params.put("preferredAirlines", this.preferredAirlines);
        params.put("segments", this.getValidSegments());
        params.put("sources", this.sources);
        return params;
    }

    private String parseTboDate(Long time) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return parser.format(parser.parse(parser.format(new Date(time))));
    }
}
