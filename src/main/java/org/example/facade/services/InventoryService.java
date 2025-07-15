package org.example.facade.services;

public class InventoryService {
    public boolean checkStock(String productId) {
        System.out.println("Checking stock for product " + productId);
        return true;
    }
}
