package org.example.visitor.impl;

import org.example.visitor.AbstructProduct;
import org.example.visitor.DiscountVisitor;
import org.example.visitor.Product;

public class Book extends AbstructProduct {
    public Book(String name, double price) {
        super(name, price);
    }

    @Override
    public double accept(DiscountVisitor visitor) {
        return visitor.visit(this);
    }
}
