package org.example.template.impl;

import org.example.template.PaymentProcessor;

public class CreditCardPayment extends PaymentProcessor {
    @Override
    protected void validate() {
        System.out.println("CreditCardPayment : validate");
    }

    @Override
    protected void connectToGateway() {
        System.out.println("CreditCardPayment : connectToGateway");
    }

    @Override
    protected void executeTransaction() {
        System.out.println("CreditCardPayment : executeTransaction");
    }
}
