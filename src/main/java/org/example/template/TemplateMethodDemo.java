package org.example.template;

import org.example.template.impl.CreditCardPayment;

public class TemplateMethodDemo {
    public static void main(String[] args) {
        System.out.println(TemplateMethodDemo.class.getSimpleName());

        CreditCardPayment creditCardPayment = new CreditCardPayment();
        creditCardPayment.processPayment();
    }
}
