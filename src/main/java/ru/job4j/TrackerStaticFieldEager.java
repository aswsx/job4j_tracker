package ru.job4j;

public class TrackerStaticFieldEager {
    private static final MemTracker INSTANCE = new MemTracker();

    private TrackerStaticFieldEager() {
    }

    public static MemTracker getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        var memTracker = TrackerStaticFieldEager.getInstance();
    }
}

