package org.example.adapter;

public class PaypalAdapter implements PaymentGateway{
    PayPalSDK payPalSDK;

    public PaypalAdapter(PayPalSDK payPalSDK) {
        this.payPalSDK = payPalSDK;
    }

    @Override
    public void pay(double amount) {
        payPalSDK.makePayment(amount); // Adapted method. if sdk changed this line to be modified.
    }
}
