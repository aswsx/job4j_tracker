package ru.job4j.tracker.ru.job4j.oop;

public class LiquidationProduct {
    private Product product;

    public LiquidationProduct(String name, int price) {
        product = new Product(name, price);
    }

    public String label() {
        return product.label();
    }
}
