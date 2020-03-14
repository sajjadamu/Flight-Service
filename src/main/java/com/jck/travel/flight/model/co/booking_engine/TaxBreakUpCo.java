package com.jck.travel.flight.model.co.booking_engine;

import java.math.BigDecimal;

public class TaxBreakUpCo {

    private String category;

    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
