package com.n11.talenthub.payment;

public class GooglePayPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println(amount + " TL Google Pay ile ödendi.");
    }
}