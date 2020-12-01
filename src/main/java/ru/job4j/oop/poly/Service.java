package ru.job4j.oop.poly;

public class Service {
    private Store store;

    public Service(Store store) {
        this.store = store;
    }

    public void extract() {
        store.save("Alexey Gutorov");
    }

    public static void main(String[] args) {
        //DbStore store = new FileStore();
        Store store = new DbStore();
        Service service = new Service(store);
        service.extract();
    }
}
