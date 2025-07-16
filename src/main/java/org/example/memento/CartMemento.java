package org.example.memento;

import java.util.ArrayList;
import java.util.List;

public class CartMemento {
    private final List<CartItem> items;

    public CartMemento(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }
}
