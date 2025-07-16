Sure! Below is a **real-world example** of how the **Visitor Pattern** can be applied (and avoided) in a typical **e-commerce application** scenario in **Java 17**.

---

## 🛒 Use Case: **Discount Calculation for Different Product Types**

You have multiple product types:

* **Book**
* **Electronics**
* **Clothing**

And each has **different discount rules**.

---

## ✅ **With Visitor Pattern**

### 1. Visitor Interface

```java
public interface DiscountVisitor {
    double visit(Book book);
    double visit(Electronics electronics);
    double visit(Clothing clothing);
}
```

---

### 2. Product Interface

```java
public interface Product {
    double accept(DiscountVisitor visitor);
}
```

---

### 3. Concrete Products

```java
public record Book(String title, double price) implements Product {
    @Override
    public double accept(DiscountVisitor visitor) {
        return visitor.visit(this);
    }
}

public record Electronics(String name, double price) implements Product {
    @Override
    public double accept(DiscountVisitor visitor) {
        return visitor.visit(this);
    }
}

public record Clothing(String brand, double price) implements Product {
    @Override
    public double accept(DiscountVisitor visitor) {
        return visitor.visit(this);
    }
}
```

---

### 4. Concrete Visitor (e.g., Summer Sale)

```java
public class SummerDiscountVisitor implements DiscountVisitor {

    @Override
    public double visit(Book book) {
        return book.price() * 0.90; // 10% off
    }

    @Override
    public double visit(Electronics electronics) {
        return electronics.price() * 0.80; // 20% off
    }

    @Override
    public double visit(Clothing clothing) {
        return clothing.price() * 0.85; // 15% off
    }
}
```

---

### 5. Using the Visitor

```java
public class DiscountEngine {
    public static void main(String[] args) {
        List<Product> cart = List.of(
            new Book("Clean Code", 50),
            new Electronics("Smartphone", 800),
            new Clothing("Nike", 120)
        );

        DiscountVisitor summerDiscount = new SummerDiscountVisitor();

        for (Product p : cart) {
            double discounted = p.accept(summerDiscount);
            System.out.printf("Final price: %.2f%n", discounted);
        }
    }
}
```

---

## ❌ **Without Visitor Pattern** (Direct logic in product classes)

You'd hardcode discount logic in each class, violating Open/Closed Principle.

### 1. Base Interface

```java
public interface Product {
    double getPrice();
    double applyDiscount();
}
```

### 2. Implementations

```java
public record Book(String title, double price) implements Product {
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double applyDiscount() {
        return price * 0.90;
    }
}

public record Electronics(String name, double price) implements Product {
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double applyDiscount() {
        return price * 0.80;
    }
}

public record Clothing(String brand, double price) implements Product {
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double applyDiscount() {
        return price * 0.85;
    }
}
```

### 3. Usage

```java
public class DiscountEngine {
    public static void main(String[] args) {
        List<Product> cart = List.of(
            new Book("Clean Code", 50),
            new Electronics("Smartphone", 800),
            new Clothing("Nike", 120)
        );

        for (Product p : cart) {
            System.out.printf("Final price: %.2f%n", p.applyDiscount());
        }
    }
}
```

---

## 🔍 Comparison

| Aspect                | Visitor Pattern                                      | Without Visitor Pattern                                 |
| --------------------- | ---------------------------------------------------- | ------------------------------------------------------- |
| Flexibility           | ✅ Easily extend new operations                       | ❌ Hard to extend without modifying classes              |
| Adding new product    | ❌ All visitors must be updated                       | ✅ Just add a new class                                  |
| Open/Closed Principle | ✅ Operations can be added without modifying products | ❌ Product class needs to change for every new operation |
| Maintainability       | ✅ Clean separation of operations                     | ❌ Logic spread across product classes                   |

---

Would you like a **Spring Boot version** or extension to **tax calculation**, **shipping**, or **reporting** using Visitor?
