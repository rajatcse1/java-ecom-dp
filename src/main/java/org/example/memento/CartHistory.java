package org.example.memento;

import java.util.List;
import java.util.Stack;

public class CartHistory {
    private final Stack<CartMemento> history = new Stack<>();

    public void save(CartMemento cartMemento) {
        history.push(cartMemento);
    }

    public CartMemento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
