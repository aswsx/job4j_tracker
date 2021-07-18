package ru.job4j.singleton;

import ru.job4j.model.Item;
import ru.job4j.store.MemTracker;

public class TrackerStaticFieldLazy {
    private static MemTracker instance;

    private TrackerStaticFieldLazy() {
    }

    public static MemTracker getInstance() {
        if (instance == null) {
            instance = new MemTracker();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        var memTracker = TrackerStaticFieldLazy.getInstance();
    }
}
