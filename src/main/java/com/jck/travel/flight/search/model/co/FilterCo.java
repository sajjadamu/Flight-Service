package com.jck.travel.flight.search.model.co;

import com.jck.travel.flight.util.enumeration.DepartTime;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class FilterCo {

    private String tokenId;

    private Integer minimumPrice;

    private Integer maximumPrice;

    private String departTime;

    private Integer noOfStops;

    private Boolean isRefundable;

    private List<String> airLines;


    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public Integer getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Integer minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public Integer getMaximumPrice() {
        return maximumPrice;
    }

    public void setMaximumPrice(Integer maximumPrice) {
        this.maximumPrice = maximumPrice;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public Integer getNoOfStops() {
        return noOfStops;
    }

    public void setNoOfStops(Integer noOfStops) {
        this.noOfStops = noOfStops;
    }

    public Boolean getIsRefundable() {
        return isRefundable;
    }

    public void setIsRefundable(Boolean isRefundable) {
        this.isRefundable = isRefundable;
    }

    public List<String> getAirLines() {
        return airLines;
    }

    public void setAirLines(List<String> airLines) {
        this.airLines = airLines;
    }

    public void setDefaultFilters() {
        if (this.minimumPrice == null || this.maximumPrice == null) {
            this.minimumPrice = 0;
            this.maximumPrice = 0;
        }

        if (this.noOfStops == null) {
            this.noOfStops = 0;

        }

        if (this.departTime == null || this.departTime.isEmpty()) {
            this.departTime = DepartTime.ANY.getTime();
        }

        if (this.airLines == null || this.airLines.isEmpty()) {
            this.airLines = new LinkedList<>();
        }

        if (this.isRefundable == null) {
            this.isRefundable = true;
        }
    }

    public static DepartTime getDepartTimeByDate(Object date) throws ParseException {
        if (date != null && date.toString().contains("T")) {

            String[] dateTime = date.toString().split("T");
            String[] time = dateTime[1].split(":");
            int hours = Integer.parseInt(time[0]);
            int minutes = Integer.parseInt(time[1]);

            if ((((Integer.compare(hours, 0) == 0 || Integer.compare(hours, 0) > 0) && (Integer.compare(hours, 5) == 0 || Integer.compare(hours, 5) < 0))
                    && ((Integer.compare(minutes, 0) == 0 || Integer.compare(minutes, 0) > 0) && (Integer.compare(minutes, 59) == 0 || Integer.compare(minutes, 59) < 0))))
                return DepartTime.NIGHT;
            else if (((Integer.compare(hours, 6) == 0 || Integer.compare(hours, 6) > 0) && (Integer.compare(hours, 11) == 0 || Integer.compare(hours, 11) < 0))
                    && ((Integer.compare(minutes, 0) == 0 || Integer.compare(minutes, 1) > 0) && (Integer.compare(minutes, 59) == 0 || Integer.compare(minutes, 59) < 0)))
                return DepartTime.DAY;
            else if (((Integer.compare(hours, 12) == 0 || Integer.compare(hours, 12) > 0) && (Integer.compare(hours, 17) == 0 || Integer.compare(hours, 17) < 0)
                    && (Integer.compare(minutes, 0) == 0 || Integer.compare(minutes, 1) > 0) && (Integer.compare(minutes, 59) == 0 || Integer.compare(minutes, 59) < 0)))
                return DepartTime.NOON;
            else if (((Integer.compare(hours, 18) == 0 || Integer.compare(hours, 18) > 0) && (Integer.compare(hours, 23) == 0 || Integer.compare(hours, 23) < 0)
                    && (Integer.compare(minutes, 0) == 0 || Integer.compare(minutes, 1) > 0) && (Integer.compare(minutes, 59) == 0 || Integer.compare(minutes, 59) < 0)))
                return DepartTime.EVENING;
            else
                return DepartTime.ANY;
        } else {
            throw new NullPointerException("Date can not be null & Must be in T format (--getDepartTimeByDate(Object date)--)");
        }
    }
}
