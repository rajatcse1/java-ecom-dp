package org.example.memento;

public class MementoDemo {
    public static void main(String[] args) {
        System.out.println(MementoDemo.class.getSimpleName());
        ShoppingCart cart = new ShoppingCart();

        cart.add(new CartItem("P001", 10));
        cart.add(new CartItem("P002", 2));
        cart.add(new CartItem("P003", 1));

        cart.displayCart();

        cart.removeItem("P002");

        cart.displayCart();

        cart.save();
        cart.add(new CartItem("P004", 15));
        cart.displayCart();

        cart.undo();

        cart.displayCart();
    }
}
