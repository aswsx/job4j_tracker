package ru.job4j;

public class TrackerStaticClassLazy {
    private TrackerStaticClassLazy() {
    }

    public static MemTracker getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final MemTracker INSTANCE = new MemTracker();
    }

    public static void main(String[] args) {
        var memTracker = TrackerStaticClassLazy.getInstance();
    }

}
