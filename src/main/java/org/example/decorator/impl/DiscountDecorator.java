package org.example.decorator.impl;

import org.example.decorator.Order;
import org.example.decorator.OrderDecorator;

public class DiscountDecorator extends OrderDecorator {
    private final double discount;
    public DiscountDecorator(Order order, double discount) {
        super(order);
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return super.getPrice() - discount;
    }

    @Override
    public String getDesc() {
        return super.getDesc() + " - Discount(" + discount + ")";
    }
}
