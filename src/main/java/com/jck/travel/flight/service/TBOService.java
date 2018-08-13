package com.jck.travel.flight.service;

import com.jck.travel.flight.model.Response;
import com.jck.travel.flight.model.co.BookingCo;
import com.jck.travel.flight.model.co.FareQuoteCo;
import com.jck.travel.flight.model.co.FareRuleCo;
import com.jck.travel.flight.util.exception.JSONResponseNotFoundException;

import java.text.ParseException;

public interface TBOService {

    public Response getFareRule(FareRuleCo fareRuleCo) throws ParseException, JSONResponseNotFoundException;

    public Response getFareQuote(FareQuoteCo fareQuoteCo) throws ParseException, JSONResponseNotFoundException;

    public Response makeBooking(BookingCo bookingCo) throws ParseException, JSONResponseNotFoundException;
}
