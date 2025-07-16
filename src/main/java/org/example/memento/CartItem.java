package org.example.memento;

public class CartItem {
    private final String productId;
    private final int count;

    public CartItem(String productId, int count) {
        this.productId = productId;
        this.count = count;
    }

    public String getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "productId='" + productId + '\'' +
                ", count=" + count +
                '}';
    }
}
