package ru.job4j.tracker.singleton;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;

public enum TrackerEnum {
    INSTANCE;
    private final MemTracker memTracker = new MemTracker();

    public MemTracker getTracker() {
        return memTracker;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        var memTracker = INSTANCE.getTracker();
    }
}
