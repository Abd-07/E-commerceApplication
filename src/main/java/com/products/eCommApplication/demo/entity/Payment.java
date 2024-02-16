package com.products.eCommApplication.demo.entity;

import com.products.eCommApplication.demo.entity.Item;

public class Payment {
    private String card_number;
    private int cvc;
    private String expiry_date;
    private Item item;

    public Payment(String card_number, int cvc, String expiry_date, Item item) {
        this.card_number = card_number;
        this.cvc = cvc;
        this.expiry_date = expiry_date;
        this.item = item;
    }

    public void setCardNumber(String card_number) {
        this.card_number = card_number;
    }
    public void setCvc(int cvc) {
        this.cvc = cvc;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiry_date = expiryDate;
    }

    public String getCard_number() {
        return card_number;
    }

    public int getCvc() {
        return cvc;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void processingAndAuth () {
        System.out.println("The payment of " + item.getPrice() + " GBP" + " is being processed");
        System.out.println("The payment of " + item.getPrice() + " GBP" + " is being authenticated");
    }
    public void paid () {
        System.out.println("The payment of " + item.getPrice() + " GBP" + " has been sent");
    }
}
