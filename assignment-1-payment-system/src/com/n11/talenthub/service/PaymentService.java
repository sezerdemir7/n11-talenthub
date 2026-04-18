package com.n11.talenthub.service;

import com.n11.talenthub.payment.PaymentMethod;

public class PaymentService {

    private PaymentMethod paymentMethod;

    public PaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        paymentMethod.pay(amount);
    }
}
