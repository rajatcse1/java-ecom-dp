package org.example.adapter;

public class CheckoutService {
    PaymentGateway paymentGateway;

    public CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void checkout(double amount){
        paymentGateway.pay(amount);
    }
}
