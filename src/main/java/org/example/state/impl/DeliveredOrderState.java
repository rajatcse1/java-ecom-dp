package org.example.state.impl;

import org.example.state.OrderContext;
import org.example.state.OrderState;

public class DeliveredOrderState implements OrderState {
    public void pay(OrderContext ctx) {
        System.out.println("Order already delivered.");
    }

    public void ship(OrderContext ctx) {
        System.out.println("Order already delivered.");
    }

    public void deliver(OrderContext ctx) {
        System.out.println("Order already delivered.");
    }

    public void cancel(OrderContext ctx) {
        System.out.println("Cannot cancel. Order delivered.");
    }
}
