package org.example.memento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();
    private final CartHistory cartHistory = new CartHistory();

    public void add(CartItem cartItem) {
        items.add(cartItem);
    }

    public void removeItem(String productId) {
        items.removeIf(items -> items.getProductId().equals(productId));
    }

    public void save() {
        cartHistory.save(new CartMemento(getItems()));
    }

    public void undo() {
        CartMemento cartMemento = cartHistory.undo();
        if (cartMemento != null) {
            items = cartMemento.getItems();
        }
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    public void displayCart() {
        System.out.println(String.format("%s", items.stream().map(item -> item.toString()).collect(Collectors.joining(", "))));
    }
}
