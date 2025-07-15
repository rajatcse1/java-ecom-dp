package org.example.chain;

public class Order {
    private boolean authenticated;
    private boolean inventoryAvailable;
    private boolean paymentValid;
    private boolean fraudulent;

    public Order(boolean authenticated, boolean inventoryAvailable, boolean paymentValid, boolean fraudulent) {
        this.authenticated = authenticated;
        this.inventoryAvailable = inventoryAvailable;
        this.paymentValid = paymentValid;
        this.fraudulent = fraudulent;
    }

    public boolean isUserAuthenticated() { return authenticated; }
    public boolean hasSufficientInventory() { return inventoryAvailable; }
    public boolean isPaymentValid() { return paymentValid; }
    public boolean isFraudulent() { return fraudulent; }
}

