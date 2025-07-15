package org.example.decorator;

public class BasicOrder implements Order{
    private double price;
    private String name;

    public BasicOrder(double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDesc() {
        return String.format(" + %s : price = %.2f", name, price);
    }
}
