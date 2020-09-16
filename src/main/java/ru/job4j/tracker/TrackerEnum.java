package ru.job4j.tracker;

public enum TrackerEnum {
    INSTANCE;
    private final Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        Tracker tracker = INSTANCE.getTracker();
    }
}
