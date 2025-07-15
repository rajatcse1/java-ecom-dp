package org.example.decorator.impl;

import org.example.decorator.Order;
import org.example.decorator.OrderDecorator;

public class GiftWrapDecorator extends OrderDecorator {
    public GiftWrapDecorator(Order order) {
        super(order);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 0.5;
    }

    @Override
    public String getDesc() {
        return super.getDesc() + " + Gift wrap(0.5) ";
    }
}
