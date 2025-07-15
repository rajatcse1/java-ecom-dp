package org.example.state.impl;

import org.example.state.OrderContext;
import org.example.state.OrderState;

public class CancelledOrderState implements OrderState {
    public void pay(OrderContext ctx) {
        System.out.println("Order is cancelled.");
    }

    public void ship(OrderContext ctx) {
        System.out.println("Order is cancelled.");
    }

    public void deliver(OrderContext ctx) {
        System.out.println("Order is cancelled.");
    }

    public void cancel(OrderContext ctx) {
        System.out.println("Order already cancelled.");
    }
}
