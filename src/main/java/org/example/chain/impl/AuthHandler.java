package org.example.chain.impl;

import org.example.chain.CheckoutHandler;
import org.example.chain.Order;

public class AuthHandler extends CheckoutHandler {
    public void handle(Order order) {
        if(!order.isUserAuthenticated()){
           throw new RuntimeException("not authenticated");
        }
        System.out.println("Authentication successful");
        super.handle(order);
    }
}
