package org.example.visitor.impl;

import org.example.visitor.DiscountVisitor;

public class SummerDiscount implements DiscountVisitor {
    @Override
    public double visit(Book book) {
        book.updatePrice(0.9); // 10% discount
        return book.getPrice();
    }

    @Override
    public double visit(Shoe shoe) {
        shoe.updatePrice(0.8); // 20% discount
        return shoe.getPrice();
    }
}
