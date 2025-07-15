package org.example.decorator;

public class OrderDecorator implements Order{
    private final Order order;

    public OrderDecorator(Order order) {
        this.order = order;
    }

    @Override
    public double getPrice() {
        return order.getPrice();
    }

    @Override
    public String getDesc() {
        return order.getDesc();
    }
}
