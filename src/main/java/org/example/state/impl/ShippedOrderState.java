package org.example.state.impl;

import org.example.state.OrderContext;
import org.example.state.OrderState;

public class ShippedOrderState implements OrderState {
    public void pay(OrderContext ctx) {
        System.out.println("Order already paid.");
    }

    public void ship(OrderContext ctx) {
        System.out.println("Order already shipped.");
    }

    public void deliver(OrderContext ctx) {
        ctx.setState(new DeliveredOrderState());
        System.out.println("Order delivered.");
    }

    public void cancel(OrderContext ctx) {
        System.out.println("Cannot cancel. Order already shipped.");
    }
}
