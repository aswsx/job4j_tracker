package ru.job4j;

import org.junit.Test;

import static org.junit.Assert.*;

public class OnlyOneInstance {

    @Test
    public void whenStaticClassLazy() {
        Tracker trackerStaticClassLazyTestone = TrackerStaticClassLazy.getInstance();
        Tracker trackerStaticClassLazyTesttwo = TrackerStaticClassLazy.getInstance();
        assertSame(trackerStaticClassLazyTestone, trackerStaticClassLazyTesttwo);
    }

    @Test
    public void whenStaticFieldEager() {
        Tracker trackerStaticFieldEagerTestone = TrackerStaticFieldEager.getInstance();
        Tracker trackerStaticFieldEagerTesttwo = TrackerStaticFieldEager.getInstance();
        assertSame(trackerStaticFieldEagerTestone, trackerStaticFieldEagerTesttwo);
    }

    @Test
    public void whenStaticFieldLazy() {
        Tracker trackerStaticFieldLazyTestone = TrackerStaticFieldLazy.getInstance();
        Tracker trackerStaticFieldLazyTesttwo = TrackerStaticFieldLazy.getInstance();
        assertSame(trackerStaticFieldLazyTestone, trackerStaticFieldLazyTesttwo);
    }

    @Test
    public void whenEnum() {
        Tracker trackerEnumTestone = TrackerEnum.INSTANCE.getTracker();
        Tracker trackerEnumTesttwo = TrackerEnum.INSTANCE.getTracker();
        assertSame(trackerEnumTestone, trackerEnumTesttwo);
    }
}