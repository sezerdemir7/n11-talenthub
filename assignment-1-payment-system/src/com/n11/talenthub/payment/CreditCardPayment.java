package com.n11.talenthub.payment;

public class CreditCardPayment implements PaymentMethod {

    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " TL kredi kartı ile ödendi. Kart: " + cardNumber);
    }
}
