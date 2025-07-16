package org.example.visitor.impl;

import org.example.visitor.AbstructProduct;
import org.example.visitor.DiscountVisitor;
import org.example.visitor.Product;

public class Shoe extends AbstructProduct {
    public Shoe(String name, double price) {
        super(name, price);
    }

    @Override
    public double accept(DiscountVisitor visitor) {
        return visitor.visit(this);
    }
}
