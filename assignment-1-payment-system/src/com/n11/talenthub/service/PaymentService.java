package com.n11.talenthub.service;

import com.n11.talenthub.payment.PaymentMethod;

public class PaymentService {

    private final PaymentMethod paymentMethod;

    public PaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Tutar 0'dan büyük olmalıdır.");
        }
        paymentMethod.pay(amount);
    }
}