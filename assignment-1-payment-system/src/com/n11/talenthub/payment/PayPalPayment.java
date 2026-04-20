package com.n11.talenthub.payment;

public class PayPalPayment implements PaymentMethod {

    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " TL PayPal ile ödendi. E-posta: " + email);
    }
}