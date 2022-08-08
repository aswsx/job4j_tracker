package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.singleton.TrackerEnum;
import ru.job4j.tracker.singleton.TrackerStaticClassLazy;
import ru.job4j.tracker.singleton.TrackerStaticFieldEager;
import ru.job4j.tracker.singleton.TrackerStaticFieldLazy;
import ru.job4j.tracker.store.MemTracker;

import static org.junit.Assert.assertSame;

public class OnlyOneInstance {

    @Test
    public void whenStaticClassLazy() {
        MemTracker memTrackerStaticClassLazyTestone = TrackerStaticClassLazy.getInstance();
        MemTracker memTrackerStaticClassLazyTesttwo = TrackerStaticClassLazy.getInstance();
        assertSame(memTrackerStaticClassLazyTestone, memTrackerStaticClassLazyTesttwo);
    }

    @Test
    public void whenStaticFieldEager() {
        MemTracker memTrackerStaticFieldEagerTestone = TrackerStaticFieldEager.getInstance();
        MemTracker memTrackerStaticFieldEagerTesttwo = TrackerStaticFieldEager.getInstance();
        assertSame(memTrackerStaticFieldEagerTestone, memTrackerStaticFieldEagerTesttwo);
    }

    @Test
    public void whenStaticFieldLazy() {
        MemTracker memTrackerStaticFieldLazyTestone = TrackerStaticFieldLazy.getInstance();
        MemTracker memTrackerStaticFieldLazyTesttwo = TrackerStaticFieldLazy.getInstance();
        assertSame(memTrackerStaticFieldLazyTestone, memTrackerStaticFieldLazyTesttwo);
    }

    @Test
    public void whenEnum() {
        MemTracker memTrackerEnumTestone = TrackerEnum.INSTANCE.getTracker();
        MemTracker memTrackerEnumTesttwo = TrackerEnum.INSTANCE.getTracker();
        assertSame(memTrackerEnumTestone, memTrackerEnumTesttwo);
    }
}