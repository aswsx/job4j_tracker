package ru.job4j.oop.pojo;

public class Book {
    private String name;
    private int pagesQty;

    public Book(String name, int pagesQty) {
        this.name = name;
        this.pagesQty = pagesQty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPagesQty() {
        return pagesQty;
    }

    public void setPagesQty(int pagesQty) {
        this.pagesQty = pagesQty;
    }
}
