package ru.job4j;

public class TrackerStaticFieldLazy {
    private static Tracker instance;

    private TrackerStaticFieldLazy() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerStaticFieldLazy.getInstance();
    }
}
