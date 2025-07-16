Sure! Let's walk through a **real-world Java 17 example** of how the **Memento design pattern** can be used **in an eCommerce application**—and contrast that with a version **not using the Memento pattern**.

---

## 🎯 Use Case: Managing Shopping Cart State

### Real-world scenario:

You're building an eCommerce app where users can **add/remove items to their cart**. You want to implement an **Undo feature**, allowing the user to revert to a previous cart state.

---

## ✅ WITH MEMENTO PATTERN

### 🔹 Components of Memento:

1. **Originator** – The object whose state you want to save (e.g., `ShoppingCart`)
2. **Memento** – Stores internal state of the Originator
3. **Caretaker** – Manages the Memento's lifecycle (e.g., handles undo/redo stack)

---

### 📦 Code

#### `CartItem.java`

```java
public record CartItem(String productId, int quantity) {}
```

#### `ShoppingCart.java` (Originator)

```java
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        items.add(item);
    }

    public void removeItem(String productId) {
        items.removeIf(i -> i.productId().equals(productId));
    }

    public List<CartItem> getItems() {
        return List.copyOf(items);
    }

    public CartMemento save() {
        return new CartMemento(new ArrayList<>(items));
    }

    public void restore(CartMemento memento) {
        items.clear();
        items.addAll(memento.items());
    }

    public static class CartMemento {
        private final List<CartItem> items;

        private CartMemento(List<CartItem> items) {
            this.items = items;
        }

        private List<CartItem> items() {
            return items;
        }
    }
}
```

#### `CartHistory.java` (Caretaker)

```java
import java.util.Stack;

public class CartHistory {
    private final Stack<ShoppingCart.CartMemento> history = new Stack<>();

    public void save(ShoppingCart cart) {
        history.push(cart.save());
    }

    public void undo(ShoppingCart cart) {
        if (!history.isEmpty()) {
            cart.restore(history.pop());
        }
    }
}
```

#### `Main.java`

```java
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        CartHistory history = new CartHistory();

        cart.addItem(new CartItem("P001", 1));
        history.save(cart);

        cart.addItem(new CartItem("P002", 2));
        history.save(cart);

        cart.removeItem("P001");

        System.out.println("Cart before undo: " + cart.getItems());

        history.undo(cart);
        System.out.println("Cart after one undo: " + cart.getItems());

        history.undo(cart);
        System.out.println("Cart after second undo: " + cart.getItems());
    }
}
```

---

## ❌ WITHOUT MEMENTO PATTERN

You can manage the state by duplicating the entire list manually wherever needed. This is less elegant and error-prone.

#### `ShoppingCartNoMemento.java`

```java
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartNoMemento {
    private final List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        items.add(item);
    }

    public void removeItem(String productId) {
        items.removeIf(i -> i.productId().equals(productId));
    }

    public List<CartItem> getItems() {
        return List.copyOf(items);
    }

    public List<CartItem> snapshot() {
        return new ArrayList<>(items);
    }

    public void restore(List<CartItem> savedState) {
        items.clear();
        items.addAll(savedState);
    }
}
```

#### `MainNoMemento.java`

```java
import java.util.Stack;

public class MainNoMemento {
    public static void main(String[] args) {
        ShoppingCartNoMemento cart = new ShoppingCartNoMemento();
        Stack<List<CartItem>> history = new Stack<>();

        cart.addItem(new CartItem("P001", 1));
        history.push(cart.snapshot());

        cart.addItem(new CartItem("P002", 2));
        history.push(cart.snapshot());

        cart.removeItem("P001");

        System.out.println("Cart before undo: " + cart.getItems());

        cart.restore(history.pop());
        System.out.println("Cart after one undo: " + cart.getItems());

        cart.restore(history.pop());
        System.out.println("Cart after second undo: " + cart.getItems());
    }
}
```

---

## ✅ Benefits of Memento Version

* **Encapsulated state** – No external access to internal structure
* **Cleaner undo logic** – Only interacts via defined `save`/`restore` methods
* **Safer evolution** – If `ShoppingCart` structure changes, no code outside needs to know

## ❌ Drawbacks Without Memento

* Exposes internal state (e.g., raw `List<CartItem>`)
* Violates encapsulation
* Higher chance of bugs and tight coupling

---

Would you like a **Spring Boot** example or a **web-based front-end interaction** for this too?
