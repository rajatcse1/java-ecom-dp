package org.example.decorator;

import org.example.decorator.impl.DiscountDecorator;
import org.example.decorator.impl.ExpressDeliveryDecorator;
import org.example.decorator.impl.GiftWrapDecorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        System.out.println("Decorator pattern");

        Order order = new BasicOrder(100, "Shoe");

        order = new GiftWrapDecorator(order);
        order = new ExpressDeliveryDecorator(order);
        order = new DiscountDecorator(order, 0.1);

        System.out.println(order.getDesc());
        System.out.println(order.getPrice());
    }
}
