package ru.job4j.singleton;

import ru.job4j.model.Item;
import ru.job4j.store.MemTracker;

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
