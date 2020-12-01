package ru.job4j;

public class TrackerStaticFieldEager {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerStaticFieldEager() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerStaticFieldEager.getInstance();
    }
}

