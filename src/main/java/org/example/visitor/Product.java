package org.example.visitor;

public interface Product {
    double accept(DiscountVisitor visitor);

    void updatePrice(double discount);
}
