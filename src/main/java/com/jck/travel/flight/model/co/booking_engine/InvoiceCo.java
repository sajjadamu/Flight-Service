package com.jck.travel.flight.model.co.booking_engine;

import org.json.JSONObject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class InvoiceCo {

    private String airlineCode;

    private String airlineTollFreeNo;

    @NotNull
    private BigDecimal invoiceAmount;

    @NotNull
    @NotBlank
    private String invoiceNo;

    @NotNull
    @NotBlank
    private String invoiceCreatedOn;

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getAirlineTollFreeNo() {
        return airlineTollFreeNo;
    }

    public void setAirlineTollFreeNo(String airlineTollFreeNo) {
        this.airlineTollFreeNo = airlineTollFreeNo;
    }

    public @NotNull BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(@NotNull BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public @NotNull @NotBlank String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(@NotNull @NotBlank String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public @NotNull @NotBlank String getInvoiceCreatedOn() {
        return invoiceCreatedOn;
    }

    public void setInvoiceCreatedOn(@NotNull @NotBlank String invoiceCreatedOn) {
        this.invoiceCreatedOn = invoiceCreatedOn;
    }

    public void setRequest(JSONObject invoice) {
        this.airlineCode = invoice.getString("airlineCode");
        this.airlineTollFreeNo = invoice.getString("airlineTollFreeNo");
        this.invoiceNo = invoice.getString("invoiceNo");
        this.invoiceAmount = invoice.getBigDecimal("invoiceAmount");
        this.invoiceCreatedOn = invoice.getString("invoiceCreatedOn");
    }
}
