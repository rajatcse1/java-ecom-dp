package org.example.decorator.impl;

import org.example.decorator.Order;
import org.example.decorator.OrderDecorator;

public class ExpressDeliveryDecorator extends OrderDecorator {
    public ExpressDeliveryDecorator(Order order) {
        super(order);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 0.3;
    }

    @Override
    public String getDesc() {
        return super.getDesc() + " + Express Delivery(0.3)";
    }
}
