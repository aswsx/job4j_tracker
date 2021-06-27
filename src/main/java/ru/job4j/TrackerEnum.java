package ru.job4j;

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
