package org.example.facade.services;

public class PaymentService {
    public void processPayment(String userId, double amount, Runnable callback) {
        new Thread(() -> {
            System.out.println("Processing payment for user " + userId + " of amount $" + amount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){}
            System.out.println("Payment successful");
            callback.run();
        }).start();
    }
}
