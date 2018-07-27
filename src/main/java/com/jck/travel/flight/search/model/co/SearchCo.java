package com.jck.travel.flight.search.model.co;

import com.jck.travel.flight.util.enumeration.CabinType;
import com.jck.travel.flight.util.enumeration.JourneyType;

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

    public Map<String, ?> getTboRequest() throws ParseException {
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("EndUserIp", this.userIp);
        params.put("TokenId", this.tokenId);
        params.put("IsDomestic", this.isDomestic);
        params.put("AdultCount", this.adultCount);
        params.put("ChildCount", this.childCount);
        params.put("InfantCount", this.infantCount);
        params.put("DirectFlight", this.directFlight);
        params.put("OneStopFlight", this.oneStopFlight);
        params.put("JourneyType", JourneyType.valueOf(this.journeyType).getTypeNo());
        params.put("PreferredAirlines", this.preferredAirlines);
        params.put("Segments", this.getValidSegments());
        params.put("Sources", this.sources);
        return params;
    }

    private List<Map<String, ?>> getValidSegments() throws ParseException {
        List<Map<String, ?>> segmentObjList = new LinkedList<>();

        for (Map<String, ?> co : this.segments) {
            Set<String> keys = co.keySet();

            if (keys.contains("origin") && keys.contains("destination") && keys.contains("flightCabinClass") && keys.contains("preferredArrivalTime")) {
                if ((co.get("origin") != null && !co.get("origin").toString().isEmpty()) && (co.get("destination") != null && !co.get("destination").toString().isEmpty()) && (co.get("flightCabinClass") != null && !co.get("flightCabinClass").toString().isEmpty()) && (co.get("preferredArrivalTime") != null && !co.get("preferredArrivalTime").toString().isEmpty()) && (co.get("preferredDepartureTime") != null && !co.get("preferredDepartureTime").toString().isEmpty())) {
                    Map<String, Object> segmentsObj = new HashMap<>();
                    segmentsObj.put("Origin", co.get("origin"));
                    segmentsObj.put("Destination", co.get("destination"));
                    segmentsObj.put("FlightCabinClass", CabinType.valueOf(co.get("flightCabinClass").toString()).getTypeNo());
                    segmentsObj.put("PreferredArrivalTime", parseTboDate(Long.valueOf(co.get("preferredArrivalTime").toString())));
                    segmentsObj.put("PreferredDepartureTime", parseTboDate(Long.valueOf(co.get("preferredDepartureTime").toString())));
                    segmentObjList.add(segmentsObj);
                }
            }
        }
        return segmentObjList;
    }

    private String parseTboDate(Long time) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return parser.format(parser.parse(parser.format(new Date(time))));
    }
}
