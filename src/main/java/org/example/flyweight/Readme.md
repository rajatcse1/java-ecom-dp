Here's a **real-world example** in Java 17 of an **eCommerce app component**—specifically a **product catalog** system—**implemented with and without the Flyweight pattern**.

The **Flyweight pattern** is ideal when many objects share common data. In an eCommerce app, a product might be shown many times (in listings, carts, recommendations), but the *product details* (e.g., description, category) are the same and can be shared.

---

## 🔹 Use Case

**Product variants in a catalog** (e.g., color/size) share common data like name, brand, and category. We use Flyweight to avoid duplicating shared product info across variants.

---

# ✅ WITHOUT Flyweight

```java
import java.util.*;

record Product(String id, String name, String brand, String category, String color, String size) {}

public class CatalogWithoutFlyweight {
    private final List<Product> products = new ArrayList<>();

    public void loadProducts() {
        // Each variant stores all product data redundantly
        products.add(new Product("1", "Sneaker Pro", "Nike", "Shoes", "Red", "10"));
        products.add(new Product("2", "Sneaker Pro", "Nike", "Shoes", "Red", "11"));
        products.add(new Product("3", "Sneaker Pro", "Nike", "Shoes", "Blue", "10"));
    }

    public void showCatalog() {
        products.forEach(System.out::println);
    }

    public static void main(String[] args) {
        var catalog = new CatalogWithoutFlyweight();
        catalog.loadProducts();
        catalog.showCatalog();
    }
}
```

### ❌ Downsides

* Duplicate storage of `"Sneaker Pro", "Nike", "Shoes"` for each product variant.
* Memory usage grows fast with many variants.

---

# ✅ WITH Flyweight

We extract shared attributes into a `ProductType` flyweight object.

---

## Step 1: Flyweight Class

```java
import java.util.*;

record ProductType(String name, String brand, String category) {}
```

---

## Step 2: Flyweight Factory

```java
class ProductTypeFactory {
    private final Map<String, ProductType> pool = new HashMap<>();

    public ProductType getProductType(String name, String brand, String category) {
        String key = name + brand + category;
        return pool.computeIfAbsent(key, k -> new ProductType(name, brand, category));
    }
}
```

---

## Step 3: Lightweight Object Holding Extrinsic State

```java
record ProductVariant(String id, String color, String size, ProductType type) {}
```

---

## Step 4: Full Catalog Example

```java
import java.util.*;

public class CatalogWithFlyweight {
    private final List<ProductVariant> variants = new ArrayList<>();
    private final ProductTypeFactory factory = new ProductTypeFactory();

    public void loadProducts() {
        ProductType type = factory.getProductType("Sneaker Pro", "Nike", "Shoes");
        variants.add(new ProductVariant("1", "Red", "10", type));
        variants.add(new ProductVariant("2", "Red", "11", type));
        variants.add(new ProductVariant("3", "Blue", "10", type));
    }

    public void showCatalog() {
        variants.forEach(v -> {
            System.out.printf("ID: %s, Color: %s, Size: %s, Name: %s, Brand: %s, Category: %s%n",
                    v.id(), v.color(), v.size(),
                    v.type().name(), v.type().brand(), v.type().category());
        });
    }

    public static void main(String[] args) {
        var catalog = new CatalogWithFlyweight();
        catalog.loadProducts();
        catalog.showCatalog();
    }
}
```

---

# 📊 Comparison

| Feature         | Without Flyweight         | With Flyweight                      |
| --------------- | ------------------------- | ----------------------------------- |
| Memory usage    | High (duplicate strings)  | Low (shared flyweights)             |
| Performance     | Slower for large datasets | Faster due to reduced GC pressure   |
| Code complexity | Simpler                   | Slightly more complex (factory)     |
| Use case fit    | Small catalogs            | Large catalogs with shared metadata |

---

# ✅ When to Use Flyweight in eCommerce Apps

* Product catalogs with many variants (color/size).
* Carts and wishlists showing repeated products.
* Warehouses managing SKUs tied to shared product info.

Would you like a version with file separation (per class) or a memory benchmarking example to compare both?
