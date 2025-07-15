package org.example.state;

public class StateDemo {
    public static void main(String[] args) {
        System.out.println(StateDemo.class.getSimpleName());
        OrderContext orderContext = new OrderContext();

        orderContext.pay();
        orderContext.ship();
        orderContext.deliver();
        orderContext.cancel();
    }
}
