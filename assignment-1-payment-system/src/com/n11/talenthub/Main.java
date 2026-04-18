package com.n11.talenthub;

import com.n11.talenthub.payment.CreditCardPayment;
import com.n11.talenthub.payment.PayPalPayment;
import com.n11.talenthub.payment.PaymentMethod;
import com.n11.talenthub.service.PaymentService;

public class Main {

    public static void main(String[] args) {


        PaymentMethod creditCard = new CreditCardPayment("1234-5678-9012");
        PaymentService service1 = new PaymentService(creditCard);
        service1.processPayment(123);

        //Sonradan eklenen PayPal ile odeme.
        PaymentMethod paypal = new PayPalPayment("test@gmail.com");
        PaymentService service2 = new PaymentService(paypal);
        service2.processPayment(321);
    }
}