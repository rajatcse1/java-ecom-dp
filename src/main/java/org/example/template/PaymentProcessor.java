package org.example.template;

public abstract class PaymentProcessor {
    protected abstract void validate();
    protected abstract void connectToGateway();
    protected abstract void executeTransaction();

    protected void sendConfirmation(){
        System.out.println("Payment successful.");
    }

    protected final void processPayment(){
        validate();
        connectToGateway();
        executeTransaction();
        sendConfirmation();
    }
}
