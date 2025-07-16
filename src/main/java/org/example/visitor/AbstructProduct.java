package org.example.visitor;

public abstract class AbstructProduct implements Product {
    private String name;
    private double price;

    public AbstructProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public abstract double accept(DiscountVisitor visitor);

    @Override
    public void updatePrice(double discount) {
        setPrice(price * discount);
    }
}
