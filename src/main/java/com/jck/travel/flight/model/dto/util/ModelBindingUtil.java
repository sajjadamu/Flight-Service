package com.jck.travel.flight.model.dto.util;

import com.jck.travel.flight.model.dto.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ModelBindingUtil {

    /*@Autowired
    private TboConfig tboConfig;*/

    public Result getResponse(JSONObject jsonResponse) {

        Result result = new Result();
        result.setOrigin(jsonResponse.getString("origin"));
        result.setDestination(jsonResponse.getString("destination"));

        JSONArray resultArray = jsonResponse.getJSONArray("results");
        for (int i = 0; i < resultArray.length(); i++) {

            JSONArray flights = resultArray.getJSONArray(i);
            for (int j = 0; j < flights.length(); j++) {

                Flight flight = new Flight();
                JSONObject jsonFlight = flights.getJSONObject(j);
                flight.setId(jsonFlight.getString("ResultIndex"));
                flight.setRefundable(jsonFlight.getBoolean("IsRefundable"));
                //flight.setSource(jsonFlight.getString("ResultIndex")); Need to set Source for JCK

                JSONArray segments = jsonFlight.getJSONArray("Segments");
                for (int s = 0; s < segments.length(); s++) {

                    JSONArray segmentWay = segments.getJSONArray(s);
                    for (int sw = 0; sw < segmentWay.length(); sw++) {
                        JSONObject segmentDetails = segmentWay.getJSONObject(sw);

                        Segment segment = new Segment();
                        segment.setDepartureTime(segmentDetails.getJSONObject("Origin").getString("DepTime"));
                        segment.setOrigin(segmentDetails.getJSONObject("Origin").getJSONObject("Airport").getString("AirportCode"));
                        segment.setArrivalTime(segmentDetails.getJSONObject("Destination").getString("ArrTime"));
                        segment.setDestination(segmentDetails.getJSONObject("Destination").getJSONObject("Airport").getString("AirportCode"));
                        segment.setETicketEligible(segmentDetails.getBoolean("IsETicketEligible"));
                        //segment.setCabinBaggage(segmentDetails.getString("CabinBaggage"));
                        segment.setAirlineCode(segmentDetails.getJSONObject("Airline").getString("AirlineCode"));
                        segment.setAirlineName(segmentDetails.getJSONObject("Airline").getString("AirlineName"));
                        segment.setFlightNumber(segmentDetails.getJSONObject("Airline").getString("FlightNumber"));
                        segment.setEquipment(segmentDetails.getString("Craft"));
                        segment.setFlightStatus(segmentDetails.getString("FlightStatus"));
                        segment.setSegmentIndicator(String.valueOf(segmentDetails.getInt("SegmentIndicator")));
                        segment.setBaggage(segmentDetails.getString("Baggage"));
                        segment.setTripIndicator(String.valueOf(segmentDetails.getInt("TripIndicator")));
                        segment.setFareClass(segmentDetails.getJSONObject("Airline").getString("FareClass"));
                        segment.setTripIndicator(String.valueOf(segmentDetails.getInt("TripIndicator")));
                        segment.setDuration(String.valueOf(segmentDetails.getInt("Duration")));
                        segment.setNoOfSeatAvailable(segmentDetails.getInt("NoOfSeatAvailable"));

                        flight.setSegments(segment);
                    }
                }

                JSONArray jsonFareRule = jsonFlight.getJSONArray("FareRules");
                for (int fr = 0; fr < jsonFareRule.length(); fr++) {
                    FareRule fareRule = new FareRule();
                    JSONObject fareRuleObj = jsonFareRule.getJSONObject(fr);
                    fareRule.setOrigin(fareRuleObj.getString("Origin"));
                    fareRule.setDestination(fareRuleObj.getString("Destination"));
                    fareRule.setFareBasisCode(fareRuleObj.getString("FareBasisCode"));
                    fareRule.setAirline(fareRuleObj.getString("Airline"));
                    fareRule.setFareRuleDetail(fareRuleObj.getString("FareRuleDetail"));
                    fareRule.setFareRestriction(fareRuleObj.getString("FareRestriction"));
                    flight.setFareRules(fareRule);
                }

                JSONObject jsonFare = jsonFlight.getJSONObject("Fare");
                Fare fare = new Fare();

                fare.setAdditionalTxnFeePub(jsonFare.getBigDecimal("AdditionalTxnFeePub"));
                fare.setTotalBaggageCharges(jsonFare.getBigDecimal("TotalBaggageCharges"));
                fare.setDiscount(jsonFare.getBigDecimal("Discount"));
                fare.setTotalSeatCharges(jsonFare.getBigDecimal("TotalSeatCharges"));
                fare.setTdsOnIncentive(jsonFare.getBigDecimal("TdsOnIncentive"));
                fare.setBaseFare(jsonFare.getBigDecimal("BaseFare"));
                fare.setCommissionEarned(jsonFare.getBigDecimal("CommissionEarned"));
                fare.setTotalTaxes(jsonFare.getBigDecimal("Tax"));
                fare.setIncentiveEarned(jsonFare.getBigDecimal("IncentiveEarned"));
                fare.setServiceFee(jsonFare.getBigDecimal("ServiceFee"));
                fare.setAdditionalTxnFeeOfrd(jsonFare.getBigDecimal("AdditionalTxnFeeOfrd"));
                fare.setTotalMealCharges(jsonFare.getBigDecimal("TotalMealCharges"));
                fare.setCurrency(jsonFare.getString("Currency"));
                fare.setTotalSpecialServiceCharges(jsonFare.getBigDecimal("TotalSpecialServiceCharges"));
                fare.setOfferedFare(jsonFare.getBigDecimal("OfferedFare"));
                fare.setTdsOnCommission(jsonFare.getBigDecimal("TdsOnCommission"));
                fare.setOtherCharges(jsonFare.getBigDecimal("OtherCharges"));
                fare.setPublishedFare(jsonFare.getBigDecimal("PublishedFare"));
                fare.setYQTax(jsonFare.getBigDecimal("YQTax"));
                fare.setPGCharge(jsonFare.getBigDecimal("PGCharge"));
                fare.setPGCharge(jsonFare.getBigDecimal("PLBEarned"));
                fare.setTdsOnPLB(jsonFare.getBigDecimal("TdsOnPLB"));

                JSONArray jsonTaxBreakup = jsonFare.getJSONArray("TaxBreakup");
                for (int tx = 0; tx < jsonTaxBreakup.length(); tx++) {
                    TaxBreakUp taxBreakUp = new TaxBreakUp();
                    taxBreakUp.setAmount(jsonTaxBreakup.getJSONObject(tx).getBigDecimal("value"));
                    taxBreakUp.setCategory(jsonTaxBreakup.getJSONObject(tx).getString("key"));
                    fare.setTaxBreakUp(taxBreakUp);
                }
                flight.setFares(fare);

                JSONArray jsonFareBreakDown = jsonFlight.getJSONArray("FareBreakdown");

                for (int fbd = 0; fbd < jsonFareBreakDown.length(); fbd++) {
                    FareBreakDown fareBreakDown = new FareBreakDown();
                    JSONObject fbdObj = jsonFareBreakDown.getJSONObject(fbd);
                    fareBreakDown.setAdditionalTxnFeePub(fbdObj.getBigDecimal("AdditionalTxnFeePub"));
                    //fareBreakDown.setPassengerType(fbdObj.getInt("PassengerType"));
                    fareBreakDown.setAdditionalTxnFeeOfrd(fbdObj.getBigDecimal("AdditionalTxnFeeOfrd"));
                    fareBreakDown.setCurrency(fbdObj.getString("Currency"));
                    fareBreakDown.setBaseFare(fbdObj.getBigDecimal("BaseFare"));
                    fareBreakDown.setTotalTax(fbdObj.getBigDecimal("Tax"));

                    TaxBreakUp taxBreakUp1 = new TaxBreakUp();
                    taxBreakUp1.setAmount(fbdObj.getBigDecimal("YQTax"));
                    taxBreakUp1.setCategory("YQTax");
                    fareBreakDown.setTaxBreakUp(taxBreakUp1);

                    TaxBreakUp taxBreakUp2 = new TaxBreakUp();
                    taxBreakUp2.setAmount(fbdObj.getBigDecimal("PGCharge"));
                    taxBreakUp2.setCategory("PGCharge");
                    fareBreakDown.setTaxBreakUp(taxBreakUp2);

                    flight.setFareBreakDowns(fareBreakDown);
                }
                //flight.setPriority(); Need to set priority for JCK
                flight.setGSTMandatory(jsonFlight.getBoolean("IsGSTMandatory"));
                flight.setGSTAllowed(jsonFlight.getBoolean("GSTAllowed"));
                flight.setLCC(jsonFlight.getBoolean("IsLCC"));
                flight.setId(jsonFlight.getString("ResultIndex"));
                result.setResults(flight);
            }
        }
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
