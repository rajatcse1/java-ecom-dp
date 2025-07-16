package org.example.visitor;

import org.example.visitor.impl.Book;
import org.example.visitor.impl.Shoe;

public interface DiscountVisitor {
    double visit(Book book);
    double visit(Shoe shoe);
}
