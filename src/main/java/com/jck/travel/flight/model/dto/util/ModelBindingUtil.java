package com.jck.travel.flight.model.dto.util;

import com.jck.travel.flight.model.dto.*;
import com.jck.travel.flight.util.enumeration.BookingStatus;
import com.jck.travel.flight.util.enumeration.TicketStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.validation.constraints.NotNull;
import java.util.*;

public abstract class ModelBindingUtil {


    public Map<String, Object> getResponse(JSONObject jsonResponse) {

        Map<String, Object> result = new LinkedHashMap<>();
        try {
            result.put("origin", jsonResponse.getString("origin"));
            result.put("destination", jsonResponse.getString("destination"));

            List<List<Flight>> totalSources = new LinkedList<>();
            List<Flight> flightList = new LinkedList<>();
            JSONArray resultArray = jsonResponse.getJSONArray("results");
            for (int i = 0; i < resultArray.length(); i++) {

                JSONArray flights = resultArray.getJSONArray(i);
                for (int j = 0; j < flights.length(); j++) {
                    setFlight(flights, flightList, j);
                }
                totalSources.add(flightList);
            }
            result.put("flights", totalSources);
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private void setFlight(JSONArray flights, List<Flight> flightList, int index) {

        Flight flight = new Flight();
        JSONObject jsonFlight = flights.getJSONObject(index);

        //flight.setId(jsonFlight.getString("ResultIndex"));
        //flight.setRefundable(jsonFlight.getBoolean("IsRefundable"));
        //flight.setSource(jsonFlight.getString("ResultIndex")); Need to set Source for JCK
        //flight.setPriority(); Need to set priority for JCK
        //flight.setGSTMandatory(jsonFlight.getBoolean("IsGSTMandatory"));
        //flight.setGSTAllowed(jsonFlight.getBoolean("GSTAllowed"));
        //flight.setLCC(jsonFlight.getBoolean("IsLCC"));

        JSONArray segments = jsonFlight.getJSONArray("Segments");
        for (int s = 0; s < segments.length(); s++) {

            JSONArray segmentWay = segments.getJSONArray(s);
            List<Segment> segmentList = new ArrayList<>();
            for (int sw = 0; sw < segmentWay.length(); sw++) {
                JSONObject segmentDetails = segmentWay.getJSONObject(sw);

                Segment segment = new Segment();
                segment.setDepartureTime(segmentDetails.getJSONObject("Origin").getString("DepTime"));
                segment.setOrigin(segmentDetails.getJSONObject("Origin").getJSONObject("Airport").getString("AirportCode"));
                segment.setArrivalTime(segmentDetails.getJSONObject("Destination").getString("ArrTime"));
                segment.setDestination(segmentDetails.getJSONObject("Destination").getJSONObject("Airport").getString("AirportCode"));
                segment.setETicketEligible(segmentDetails.getBoolean("IsETicketEligible"));
                //segment.setCabinBaggage(segmentDetails.getString("CabinBaggage"));
                //segment.setAirlineCode(segmentDetails.getJSONObject("Airline").getString("AirlineCode"));
                //segment.setAirlineName(segmentDetails.getJSONObject("Airline").getString("AirlineName"));
                //segment.setFlightNumber(segmentDetails.getJSONObject("Airline").getString("FlightNumber"));
                segment.setEquipment(segmentDetails.getString("Craft"));
                //segment.setFlightStatus(segmentDetails.getString("FlightStatus"));
                //segment.setSegmentIndicator(String.valueOf(segmentDetails.getInt("SegmentIndicator")));

                //if (!segmentDetails.isNull("Baggage"))
                   // segment.setBaggage(segmentDetails.getString("Baggage"));
                //else
                 //   segment.setBaggage(null);

               // segment.setTripIndicator(String.valueOf(segmentDetails.getInt("TripIndicator")));
               // segment.setFareClass(segmentDetails.getJSONObject("Airline").getString("FareClass"));
             //   segment.setTripIndicator(String.valueOf(segmentDetails.getInt("TripIndicator")));
                //segment.setDuration(String.valueOf(segmentDetails.getInt("Duration")));
                //segment.setNoOfSeatAvailable(segmentDetails.getInt("NoOfSeatAvailable"));
                segmentList.add(segment);
            }
           // flight.setSegments(segmentList);
        }

        // Set fare in flight object
        List<FareRule> jsonFareRule = setFareRule(jsonFlight.getJSONArray("FareRules"));
        for (FareRule aJsonFareRule : jsonFareRule) {
         //   flight.setFareRules(aJsonFareRule);
        }

        // Set fare in flight object
        //flight.setFares(setFare(jsonFlight.getJSONObject("Fare")));

        JSONArray jsonFareBreakDown = jsonFlight.getJSONArray("FareBreakdown");
        for (int fbd = 0; fbd < jsonFareBreakDown.length(); fbd++) {
            FareBreakDown fareBreakDown = new FareBreakDown();
            JSONObject fbdObj = jsonFareBreakDown.getJSONObject(fbd);
            //fareBreakDown.setAdditionalTxnFeePub(fbdObj.getBigDecimal("AdditionalTxnFeePub"));
            //fareBreakDown.setPassengerType(fbdObj.getInt("PassengerType"));
            //fareBreakDown.setAdditionalTxnFeeOfrd(fbdObj.getBigDecimal("AdditionalTxnFeeOfrd"));
            fareBreakDown.setCurrency(fbdObj.getString("Currency"));
            //fareBreakDown.setBaseFare(fbdObj.getBigDecimal("BaseFare"));
            //fareBreakDown.setTotalTax(fbdObj.getBigDecimal("Tax"));


           // flight.setFareBreakDowns(fareBreakDown);
        }

        flightList.add(flight);
    }


    private Fare setFare(JSONObject jsonFare) {
        Fare fare = new Fare();

        //fare.setAdditionalTxnFeePub(jsonFare.getBigDecimal("AdditionalTxnFeePub"));
        //fare.setTotalBaggageCharges(jsonFare.getBigDecimal("TotalBaggageCharges"));
        //fare.setDiscount(jsonFare.getBigDecimal("Discount"));
        //fare.setTotalSeatCharges(jsonFare.getBigDecimal("TotalSeatCharges"));
        //fare.setTdsOnIncentive(jsonFare.getBigDecimal("TdsOnIncentive"));
        //fare.setBaseFare(jsonFare.getBigDecimal("BaseFare"));
        //fare.setCommissionEarned(jsonFare.getBigDecimal("CommissionEarned"));
        //fare.setTotalTaxes(jsonFare.getBigDecimal("Tax"));
        //fare.setIncentiveEarned(jsonFare.getBigDecimal("IncentiveEarned"));
        //fare.setServiceFee(jsonFare.getBigDecimal("ServiceFee"));
        //fare.setAdditionalTxnFeeOfrd(jsonFare.getBigDecimal("AdditionalTxnFeeOfrd"));
        //fare.setTotalMealCharges(jsonFare.getBigDecimal("TotalMealCharges"));
        fare.setCurrency(jsonFare.getString("Currency"));
        //fare.setTotalSpecialServiceCharges(jsonFare.getBigDecimal("TotalSpecialServiceCharges"));
        //fare.setOfferedFare(jsonFare.getBigDecimal("OfferedFare"));
        //fare.setTdsOnCommission(jsonFare.getBigDecimal("TdsOnCommission"));
        //fare.setOtherCharges(jsonFare.getBigDecimal("OtherCharges"));
        //fare.setPublishedFare(jsonFare.getBigDecimal("PublishedFare"));
       //fare.setYQTax(jsonFare.getBigDecimal("YQTax"));
        //fare.setPGCharge(jsonFare.getBigDecimal("PGCharge"));
        //fare.setPGCharge(jsonFare.getBigDecimal("PLBEarned"));
        //fare.setTdsOnPLB(jsonFare.getBigDecimal("TdsOnPLB"));

        JSONArray jsonTaxBreakup = jsonFare.getJSONArray("TaxBreakup");
        for (int tx = 0; tx < jsonTaxBreakup.length(); tx++) {

        }
        return fare;
    }


    private List<FareRule> setFareRule(JSONArray fareRuleArray) {
        List<FareRule> result = new LinkedList<>();
        for (int i = 0; i < fareRuleArray.length(); i++) {
            JSONObject fareRuleObj = fareRuleArray.getJSONObject(i);

            FareRule fareRule = new FareRule();
            fareRule.setOrigin(fareRuleObj.getString("Origin"));
            fareRule.setDestination(fareRuleObj.getString("Destination"));
            fareRule.setFareBasisCode(fareRuleObj.getString("FareBasisCode"));
            fareRule.setAirline(fareRuleObj.getString("Airline"));

            if (fareRuleObj.has("FareRuleDetail") && !fareRuleObj.isNull("FareRuleDetail"))
                fareRule.setFareRuleDetail(fareRuleObj.getString("FareRuleDetail"));
            else
                fareRule.setFareRuleDetail(null);

            if (fareRuleObj.has("FareRuleDetail") && !fareRuleObj.isNull("FareRestriction"))
                fareRule.setFareRestriction(fareRuleObj.getString("FareRestriction"));
            else
                fareRule.setFareRestriction(null);

            result.add(fareRule);
        }
        return result;
    }

    public List<FareRule> getFareRuleResponse(JSONArray fareRuleArray) {
        return setFareRule(fareRuleArray);
    }

    //Re-Pricing Response Handling
    public Map<String, Object> getFareQuoteResponse(Boolean isPriceChanged, JSONObject flight) {
        Map<String, Object> result = new LinkedHashMap<>();

        result.put("isPriceChanged", isPriceChanged);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(flight);

        List<Flight> flightList = new LinkedList<>();
        setFlight(jsonArray, flightList, 0);

        result.put("flight", flightList.get(0));
        return result;
    }

    private List<Map<String, Object>> getBookingSegments(JSONArray segments) {
        List<Map<String, Object>> segmentsList = new LinkedList<>();
        for (int i = 0; i < segments.length(); i++) {
            Map<String, Object> segmentMap = new LinkedHashMap<>();
            JSONObject segmentObj = segments.getJSONObject(i);
            segmentMap.put("tripIndicator", segmentObj.getInt("TripIndicator"));
            segmentMap.put("segmentIndicator", segmentObj.getInt("SegmentIndicator"));
            segmentMap.put("status", segmentObj.getString("Status"));
            segmentMap.put("isETicketEligible", segmentObj.getBoolean("IsETicketEligible"));
            segmentMap.put("craft", segmentObj.getString("Craft"));
            segmentMap.put("flightStatus", segmentObj.getString("FlightStatus"));
            segmentMap.put("duration", segmentObj.getInt("Duration"));
            //segmentMap.put("accumulatedDuration", segmentObj.getInt("AccumulatedDuration"));
            segmentMap.put("mile", segmentObj.getInt("Mile"));
            segmentMap.put("groundTime", segmentObj.getInt("GroundTime"));
            segmentMap.put("stopOver", segmentObj.getBoolean("StopOver"));

            if (segmentObj.has("Baggage") && !segmentObj.isNull("Baggage"))
                segmentMap.put("baggage", segmentObj.get("Baggage"));
            else
                segmentMap.put("baggage", null);

            if (segmentObj.has("CabinBaggage") && !segmentObj.isNull("CabinBaggage"))
                segmentMap.put("cabinBaggage", segmentObj.get("CabinBaggage"));
            else
                segmentMap.put("cabinBaggage", null);

            if (segmentObj.has("Remark") && !segmentObj.isNull("Remark"))
                segmentMap.put("remark", segmentObj.getString("Remark"));
            else
                segmentMap.put("remark", null);

            Map<String, Object> origin = new LinkedHashMap<>();
            origin.put("airportCode", segmentObj.getJSONObject("Origin").getJSONObject("Airport").getString("AirportCode"));
            origin.put("originDepTime", segmentObj.getJSONObject("Origin").getString("DepTime"));
            origin.put("airportName", segmentObj.getJSONObject("Origin").getJSONObject("Airport").getString("AirportName"));
            origin.put("terminal", segmentObj.getJSONObject("Origin").getJSONObject("Airport").getString("Terminal"));
            segmentMap.put("origin", origin);

            Map<String, Object> destination = new LinkedHashMap<>();
            destination.put("destinationArrTime", segmentObj.getJSONObject("Destination").getString("ArrTime"));
            destination.put("airportCode", segmentObj.getJSONObject("Destination").getJSONObject("Airport").getString("AirportCode"));
            destination.put("airportName", segmentObj.getJSONObject("Destination").getJSONObject("Airport").getString("AirportName"));
            destination.put("terminal", segmentObj.getJSONObject("Destination").getJSONObject("Airport").getString("Terminal"));
            segmentMap.put("destination", destination);

            Map<String, Object> airline = new LinkedHashMap<>();
            airline.put("airlineCode", segmentObj.getJSONObject("Airline").getString("AirlineCode"));
            airline.put("airlineName", segmentObj.getJSONObject("Airline").getString("AirlineName"));
            segmentMap.put("airline", airline);

            segmentMap.put("flightNumber", segmentObj.getJSONObject("Airline").getString("FlightNumber"));
            segmentMap.put("fareClass", segmentObj.getJSONObject("Airline").getString("FareClass"));

            segmentsList.add(segmentMap);
        }

        return segmentsList;
    }

    private Map<String, Object> getTicket(JSONObject ticket) {
        Map<String, Object> ticketMap = new LinkedHashMap<>();

        ticketMap.put("ticketId", ticket.getBigInteger("TicketId"));
        ticketMap.put("ticketNumber", ticket.getString("TicketNumber"));
        ticketMap.put("issueDate", ticket.getString("IssueDate"));
        ticketMap.put("validatingAirline", ticket.getString("ValidatingAirline"));
        ticketMap.put("remarks", ticket.getString("Remarks"));
        ticketMap.put("serviceFeeDisplayType", ticket.getString("ServiceFeeDisplayType"));
        ticketMap.put("conjunctionNumber", ticket.getString("ConjunctionNumber"));
        ticketMap.put("ticketType", ticket.getString("TicketType"));
        return ticketMap;
    }

    private List<Map<String, Object>> getPassengerList(JSONArray passenger) {

        List<Map<String, Object>> passengerList = new LinkedList<>();
        for (int j = 0; j < passenger.length(); j++) {
            JSONObject passengerObj = passenger.getJSONObject(j);
            Map<String, Object> passengerMap = new LinkedHashMap<>();

            passengerMap.put("dateOfBirth", passengerObj.getString("DateOfBirth"));
            passengerMap.put("isLeadPax", passengerObj.getBoolean("IsLeadPax"));
            passengerMap.put("title", passengerObj.getString("Title"));
            passengerMap.put("firstName", passengerObj.getString("FirstName"));
            passengerMap.put("lastName", passengerObj.getString("LastName"));
            passengerMap.put("passportNo", passengerObj.getString("PassportNo"));

            if (passengerObj.has("PassportExpiry"))
                passengerMap.put("passportExpiry", passengerObj.getString("PassportExpiry"));

            passengerMap.put("nationality", passengerObj.getString("Nationality"));
            passengerMap.put("gender", passengerObj.getInt("Gender"));

            if (passengerObj.has("CountryName") && !passengerObj.isNull("CountryName"))
                passengerMap.put("countryName", passengerObj.getString("CountryName"));
            else
                passengerMap.put("countryName", null);


            if (passengerObj.has("CountryCode") && !passengerObj.isNull("CountryCode"))
                passengerMap.put("countryCode", passengerObj.getString("CountryCode"));
            else
                passengerMap.put("countryCode", null);

            passengerMap.put("paxType", passengerObj.getInt("PaxType"));

            //passengerMap.put("ssr", passengerObj.getJSONArray("Ssr"));
            //passengerMap.put("segmentAdditionalInfo", passengerObj.getJSONArray("SegmentAdditionalInfo"));
            passengerMap.put("fare", setFare(passengerObj.getJSONObject("Fare")));

            if (passengerObj.has("FFNumber") && !passengerObj.isNull("FFNumber"))
                passengerMap.put("FFNumber", passengerObj.getString("FFNumber"));
            else
                passengerMap.put("FFNumber", null);

            if (passengerObj.has("FFAirlineCode") && !passengerObj.isNull("FFAirlineCode"))
                passengerMap.put("FFAirlineCode", passengerObj.getString("FFAirlineCode"));
            else
                passengerMap.put("FFAirlineCode", null);

            if (passengerObj.has("Fare") && !passengerObj.isNull("Fare"))
                passengerMap.put("fare", setFare(passengerObj.getJSONObject("Fare")));

            if (passengerObj.has("Ticket") && !passengerObj.isNull("Ticket"))
                passengerMap.put("ticket", getTicket(passengerObj.getJSONObject("Ticket")));

            passengerList.add(passengerMap);
        }
        return passengerList;
    }

    public Map<String, Object> nonLCCHolding(JSONObject booking) {
        Map<String, Object> result = new LinkedHashMap<>();

        result.put("isPriceChanged", booking.getBoolean("IsPriceChanged"));
        result.put("isTimeChanged", booking.getBoolean("IsTimeChanged"));
        result.put("bookingId", booking.getBigInteger("BookingId"));
        result.put("PNR", booking.getString("PNR"));
        result.put("status", BookingStatus.getStatus(booking.getInt("Status")));

        Map<String, Object> bookingMap = new LinkedHashMap<>();
        JSONObject bookingObj = booking.getJSONObject("FlightItinerary");

        bookingMap.put("origin", bookingObj.getString("Origin"));
        bookingMap.put("destination", bookingObj.getString("Destination"));
        bookingMap.put("isManual", bookingObj.getBoolean("IsManual"));
        bookingMap.put("bookingAllowedForRoamer", bookingObj.getBoolean("BookingAllowedForRoamer"));
        bookingMap.put("fareType", bookingObj.getString("FareType"));
        bookingMap.put("validatingAirlineCode", bookingObj.getString("ValidatingAirlineCode"));
        bookingMap.put("nonRefundable", bookingObj.getBoolean("NonRefundable"));
        bookingMap.put("isDomestic", bookingObj.getBoolean("IsDomestic"));
        bookingMap.put("airlineCode", bookingObj.getString("AirlineCode"));
        //bookingMap.put("cancellationCharges", "CancellationCharges");

        bookingMap.put("fare", setFare(bookingObj.getJSONObject("Fare")));

        bookingMap.put("fareRules", setFareRule(bookingObj.getJSONArray("FareRules")));

        bookingMap.put("segments", getBookingSegments(bookingObj.getJSONArray("Segments")));

        bookingMap.put("passengers", getPassengerList(bookingObj.getJSONArray("Passenger")));

        result.put("booking", bookingMap);
        return result;
    }

    public Map<String, Object> getTicketResponse(JSONObject ticket) {
        Map<String, Object> result = new LinkedHashMap<>();

      /*"SSRDenied":false,
        "SSRMessage":null,*/
        result.put("PNR", ticket.getString("PNR"));
        result.put("bookingId", ticket.getBigInteger("BookingId"));
        result.put("isPriceChanged", ticket.getBoolean("IsPriceChanged"));
        result.put("isTimeChanged", ticket.getBoolean("IsTimeChanged"));
        result.put("ticketStatus", TicketStatus.getStatus(ticket.getInt("TicketStatus")));

        Map<String, Object> ticketMap = new LinkedHashMap<>();

        JSONObject ticketObj = ticket.getJSONObject("FlightItinerary");

        result.put("bookingStatus", BookingStatus.getStatus(ticketObj.getInt("Status")));
        ticketMap.put("origin", ticketObj.getString("Origin"));
        ticketMap.put("destination", ticketObj.getString("Destination"));
        ticketMap.put("isManual", ticketObj.getBoolean("IsManual"));
        ticketMap.put("bookingAllowedForRoamer", ticketObj.getBoolean("BookingAllowedForRoamer"));
        ticketMap.put("isDomestic", ticketObj.getBoolean("IsDomestic"));
        ticketMap.put("isLCC", ticketObj.getBoolean("IsLCC"));
        ticketMap.put("nonRefundable", ticketObj.getBoolean("NonRefundable"));
        ticketMap.put("airlineCode", ticketObj.getString("AirlineCode"));

        if (ticketObj.has("AirlineTollFreeNo"))
            ticketMap.put("airlineTollFreeNo", ticketObj.getString("AirlineTollFreeNo"));
        else
            ticketMap.put("airlineTollFreeNo", "");

        ticketMap.put("fareType", ticketObj.getString("FareType"));
        //ticketMap.put("cancellationCharges", "CancellationCharges");

        ticketMap.put("fare", setFare(ticketObj.getJSONObject("Fare")));

        ticketMap.put("fareRules", setFareRule(ticketObj.getJSONArray("FareRules")));

        Map<String, Object> invoiceMap = new LinkedHashMap<>();
        invoiceMap.put("invoiceAmount", ticketObj.getBigDecimal("InvoiceAmount"));
        invoiceMap.put("invoiceNo", ticketObj.getString("InvoiceNo"));
        //invoiceMap.put("InvoiceStatus", ticketObj.getInt("InvoiceStatus"));
        invoiceMap.put("invoiceCreatedOn", ticketObj.getString("InvoiceCreatedOn"));
        ticketMap.put("invoice", invoiceMap);

        ticketMap.put("segments", getBookingSegments(ticketObj.getJSONArray("Segments")));

        ticketMap.put("passengers", getPassengerList(ticketObj.getJSONArray("Passenger")));

        result.put("ticket", ticketMap);
        return result;
    }


    public void makeJavaMap(JSONObject jsonResponse) {
        Map<String, Object> mapResponse = jsonResponse.toMap();

        for (Map.Entry<String, ?> entry : mapResponse.entrySet()) {
            if (isArray(entry.getValue().getClass())) {
                for (Object object : getArray(entry.getValue())) {
                    if (isArray(object.getClass())) {
                        System.out.println("If Value Class :" + object.getClass());
                        for (Object innerObject : (List) object) {
                            System.out.println("If in loop Value Class :" + innerObject.getClass());

                        }
                    } else {
                        System.out.println("Else Value Class :" + object.getClass());
                    }
                }
                System.out.println("Key Class :" + entry.getKey().getClass() + " ----------   Value Class :" + entry.getValue().getClass());
            } else if (isString(entry.getValue().getClass())) {
                System.out.println("Key Class :" + entry.getKey().getClass() + " ----------   Value Class :" + entry.getValue().getClass());

            } else {
            }
        }
    }

    private boolean testObjectStructure(Object object) {
        if (isArray(object.getClass())) {
            testObjectStructure(object);
        } else if (isString(object.getClass())) {
            testObjectStructure(object);
        } else if (isMap(object.getClass())) {
            testObjectStructure(object);
        }
        return false;
    }

    private boolean isArray(Class clazz) {
        return ArrayList.class.equals(clazz);
    }

    private boolean isString(Class clazz) {
        return String.class.equals(clazz);
    }

    private boolean isMap(Class clazz) {
        return HashMap.class.equals(clazz);
    }

    private List getArray(@NotNull Object object) {
        return (List) object;
    }

    private String getString(@NotNull Object object) {
        return (String) object;
    }

    private Map getMap(@NotNull Object object) {
        return (Map) object;
    }
}
