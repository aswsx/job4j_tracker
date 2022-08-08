package ru.job4j.tracker.singleton;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;

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

