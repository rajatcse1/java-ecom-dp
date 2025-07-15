package org.example.adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        System.out.println(AdapterDemo.class.getSimpleName());

        PayPalSDK payPalSDK = new PayPalSDK();
        PaymentGateway adapter = new PaypalAdapter(payPalSDK);
        CheckoutService checkoutService = new CheckoutService(adapter);
        checkoutService.checkout(100);
    }
}
