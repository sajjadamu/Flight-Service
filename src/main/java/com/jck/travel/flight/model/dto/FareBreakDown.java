package com.jck.travel.flight.model.dto;


import com.jck.travel.flight.util.enumeration.PaxType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FareBreakDown {

    private String id;

    private String totalFare;

    private BigDecimal baseFare; // Same for TBO, Galileo

    private BigDecimal totalTax; //For TBO
    
    private BigDecimal gstAmount;

    private List<TaxBreakUp> taxBreakUp = new ArrayList<>(); // This properties for TBO ("YQTax","PGCharge"), and galileo gives full breakup

    private PaxType passengerType;

    private Map<String, ?> changePenalty; // For Galileo

    private Map<String, ?> cancelPenalty; // For Galileo

    private BigDecimal additionalTxnFeePub;

    private BigDecimal additionalTxnFeeOfrd;

    private String currency;
    
    private String cancelationCharges;

    public String getCancelationCharges() {
		return cancelationCharges;
	}

	public void setCancelationCharges(String cancelationCharges) {
		this.cancelationCharges = cancelationCharges;
	}

	public String getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(String totalFare) {
        this.totalFare = totalFare;
    }

    public BigDecimal getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(BigDecimal baseFare) {
        this.baseFare = baseFare;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public List<TaxBreakUp> getTaxBreakUp() {
        return taxBreakUp;
    }

    public void setTaxBreakUp(TaxBreakUp taxBreakUp) {
        if (taxBreakUp != null)
            this.taxBreakUp.add(taxBreakUp);
    }

    public PaxType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PaxType passengerType) {
        this.passengerType = passengerType;
    }

    public Map<String, ?> getChangePenalty() {
        return changePenalty;
    }

    public void setChangePenalty(Map<String, ?> changePenalty) {
        this.changePenalty = changePenalty;
    }

    public Map<String, ?> getCancelPenalty() {
        return cancelPenalty;
    }

    public void setCancelPenalty(Map<String, ?> cancelPenalty) {
        this.cancelPenalty = cancelPenalty;
    }

    public BigDecimal getAdditionalTxnFeePub() {
        return additionalTxnFeePub;
    }

    public void setAdditionalTxnFeePub(BigDecimal additionalTxnFeePub) {
        this.additionalTxnFeePub = additionalTxnFeePub;
    }

    public BigDecimal getAdditionalTxnFeeOfrd() {
        return additionalTxnFeeOfrd;
    }

    public void setAdditionalTxnFeeOfrd(BigDecimal additionalTxnFeeOfrd) {
        this.additionalTxnFeeOfrd = additionalTxnFeeOfrd;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public BigDecimal getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(BigDecimal gstAmount) {
		this.gstAmount = gstAmount;
	}
}
