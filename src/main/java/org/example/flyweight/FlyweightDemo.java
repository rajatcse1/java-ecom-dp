package org.example.flyweight;

import java.util.List;

public class FlyweightDemo {
    public static void main(String[] args) {
        System.out.println(FlyweightDemo.class.getSimpleName());
        FlyweightTagFactory factory = new FlyweightTagFactory();

        Tag electronicsTag = factory.getTag(TagType.ELECTRONICS);
        Tag saleTag = factory.getTag(TagType.SALE);
        Tag newTag = factory.getTag(TagType.NEW_ARRIVAL);

        Product product = new Product("product1", 10, List.of(electronicsTag, saleTag, newTag, saleTag, saleTag));

        product.display();
    }
}
