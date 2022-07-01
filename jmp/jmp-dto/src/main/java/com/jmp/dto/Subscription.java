package com.jmp.dto;

import java.time.LocalDate;
//this class create a subscriptions for a bankCard and receive a start date
public class Subscription {
    String bankcard;
    LocalDate startDate;

    public Subscription(String bankcard, LocalDate startDate) {
        this.bankcard = bankcard;
        this.startDate = startDate;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                 bankcard +
                ", startDate=" + startDate +
                '}';
    }
}
