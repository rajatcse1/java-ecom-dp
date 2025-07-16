package org.example.flyweight;

import java.util.List;
import java.util.stream.Collectors;

public class Product {
    private final String name;
    private final double price;
    private final List<Tag> tags;

    public Product(String name, double price, List<Tag> tags) {
        this.name = name;
        this.price = price;
        this.tags = tags;
    }

    public void display() {
        System.out.println(String.format(
                        """
                                Product {
                                    name: %s,
                                    price: %.2f
                                    tags: %s
                                }
                                """,
                        name,
                        price,
                        tags.stream()
                                .map(Tag::getTag)
                                .collect(Collectors.joining(", "))
                )
        );
    }
}
