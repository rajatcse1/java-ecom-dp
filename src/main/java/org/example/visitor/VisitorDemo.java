package org.example.visitor;

import org.example.visitor.impl.Book;
import org.example.visitor.impl.Shoe;
import org.example.visitor.impl.SummerDiscount;
import org.example.visitor.impl.VipDiscount;

import java.util.List;

public class VisitorDemo {
    public static void main(String[] args) {
        System.out.println(VisitorDemo.class.getSimpleName());

        List<Product> products = List.of(
           new Book("Book1", 10),
           new Shoe("Shoe1", 20)
        );

        DiscountVisitor summerDiscount = new SummerDiscount();
        DiscountVisitor vipDiscount = new VipDiscount();

        products.forEach(product -> {
            product.accept(vipDiscount);
            double discountedPrice = product.accept(summerDiscount);
            System.out.println(String.format("Final price : %.2f", discountedPrice));
        });
    }
}
