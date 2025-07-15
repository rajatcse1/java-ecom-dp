package org.example.state.impl;

import org.example.state.OrderContext;
import org.example.state.OrderState;

public class NewOrderState implements OrderState {
    public void pay(OrderContext ctx) {
        ctx.setState(new PaidOrderState());
        System.out.println("Order paid.");
    }

    public void ship(OrderContext ctx) {
        System.out.println("Cannot ship. Order not paid yet.");
    }

    public void deliver(OrderContext ctx) {
        System.out.println("Cannot deliver. Order not shipped.");
    }

    public void cancel(OrderContext ctx) {
        ctx.setState(new CancelledOrderState());
        System.out.println("Order cancelled.");
    }
}
