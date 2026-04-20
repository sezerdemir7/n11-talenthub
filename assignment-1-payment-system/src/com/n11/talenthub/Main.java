package com.n11.talenthub;

import com.n11.talenthub.factory.PaymentFactory;
import com.n11.talenthub.payment.PaymentMethod;
import com.n11.talenthub.service.PaymentService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> paymentMethods = PaymentFactory.getPaymentMethods();

        System.out.println("Kullanılabilir ödeme yöntemleri:");
        for (String method : paymentMethods) {
            System.out.println("- " + method);
        }

        System.out.print("Ödeme yöntemini yazın: ");
        String selected = scanner.nextLine().trim();

        if (!paymentMethods.contains(selected)) {
            System.out.println("Geçersiz ödeme yöntemi girdiniz.");
            return;
        }

        PaymentMethod paymentMethod = PaymentFactory.createPaymentMethod(selected);
        PaymentService service = new PaymentService(paymentMethod);

        System.out.print("Ödeme tutarını girin: ");

        try {
            double amount = scanner.nextDouble();

            System.out.println();
            service.processPayment(amount);
            System.out.println("İşlem tamamlandı.");

        } catch (InputMismatchException e) {
            System.out.println("Geçerli bir sayı giriniz.");
        } catch (IllegalArgumentException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}