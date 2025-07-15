package org.example.adapter;

public class PayPalSDK {
    public void makePayment(double amount){
        System.out.println(String.format("%.2f Paypal payment done", amount));
    }
}
