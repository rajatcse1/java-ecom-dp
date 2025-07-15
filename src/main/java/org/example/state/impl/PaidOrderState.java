package org.example.state.impl;

import org.example.state.OrderContext;
import org.example.state.OrderState;

public class PaidOrderState implements OrderState {
    public void pay(OrderContext ctx) {
        System.out.println("Order already paid.");
    }

    public void ship(OrderContext ctx) {
        ctx.setState(new ShippedOrderState());
        System.out.println("Order shipped.");
    }

    public void deliver(OrderContext ctx) {
        System.out.println("Cannot deliver. Order not shipped.");
    }

    public void cancel(OrderContext ctx) {
        ctx.setState(new CancelledOrderState());
        System.out.println("Order cancelled.");
    }
}
