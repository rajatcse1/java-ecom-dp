package org.example.chain.impl;

import org.example.chain.CheckoutHandler;
import org.example.chain.Order;

public class InventoryHandler extends CheckoutHandler {
    public void handle(Order order) {
        if (!order.hasSufficientInventory()) {
            throw new RuntimeException("Insufficient inventory");
        }
        System.out.println("Inventory check passed");
        super.handle(order);
    }
}
