package org.example.chain;

public abstract class CheckoutHandler {
    protected CheckoutHandler next;

    public CheckoutHandler setNext(CheckoutHandler checkoutHandler) {
        this.next = checkoutHandler;
        return checkoutHandler;
    }

    public void handle(Order order){
        if(next != null){
           next.handle(order);
        }
    }
}
