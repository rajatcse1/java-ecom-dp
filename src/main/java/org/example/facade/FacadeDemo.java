package org.example.facade;

public class FacadeDemo {
    public static void main(String[] args) {
        System.out.println(FacadeDemo.class.getSimpleName());

        OrderFacade orderFacade = new OrderFacade();
        orderFacade.placeOrder("Product1", "user1", 100, "order1", "email1");
    }
}
