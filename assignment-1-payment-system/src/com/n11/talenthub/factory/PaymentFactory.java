package com.n11.talenthub.factory;

import com.n11.talenthub.payment.PaymentMethod;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PaymentFactory {

    private static final String PACKAGE_NAME = "com.n11.talenthub.payment";

    // PaymentMethod interface'ini implement eden siniflari reflection ile bulup listeler
    public static List<String> getPaymentMethods() {
        List<String> classNames = new ArrayList<>();

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String path = PACKAGE_NAME.replace('.', '/');
            URL resource = classLoader.getResource(path);

            if (resource == null) return classNames;

            File folder = new File(resource.toURI());

            for (File file : folder.listFiles()) {
                String fileName = file.getName();

                if (fileName.endsWith(".class")) {
                    String className = fileName.replace(".class", "");

                    Class<?> clazz = Class.forName(PACKAGE_NAME + "." + className);

                    if (PaymentMethod.class.isAssignableFrom(clazz)
                            && !clazz.isInterface()) {
                        classNames.add(className);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return classNames;
    }

    public static PaymentMethod createPaymentMethod(String paymentType) {
        try {
            String fullName = PACKAGE_NAME + "." + paymentType;
            Class<?> clazz = Class.forName(fullName);
            return (PaymentMethod) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Geçersiz ödeme yöntemi");
        }
    }
}