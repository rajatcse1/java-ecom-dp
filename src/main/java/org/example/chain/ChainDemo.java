package org.example.chain;

import org.example.chain.impl.AuthHandler;
import org.example.chain.impl.InventoryHandler;

public class ChainDemo {
    public static void main(String[] args) {
        System.out.println(ChainDemo.class.getSimpleName());
        Order order = new Order(true, true, true, false);

        CheckoutHandler chain = new AuthHandler();
                chain.setNext(new InventoryHandler());

        chain.handle(order);
    }
}
