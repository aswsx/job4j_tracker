package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class OnlyOneInstance {

    @Test
    public void whenStaticClassLazy() {
        Tracker trackerStaticClassLazyTestone = TrackerStaticClassLazy.getInstance();
        Tracker trackerStaticClassLazyTesttwo = TrackerStaticClassLazy.getInstance();
        assertThat(trackerStaticClassLazyTestone == trackerStaticClassLazyTesttwo, is(true));
    }

    @Test
    public void whenStaticFieldEager() {
        Tracker trackerStaticFieldEagerTestone = TrackerStaticFieldEager.getInstance();
        Tracker trackerStaticFieldEagerTesttwo = TrackerStaticFieldEager.getInstance();
        assertThat(trackerStaticFieldEagerTestone == trackerStaticFieldEagerTesttwo, is(true));
    }

    @Test
    public void whenStaticFieldLazy() {
        Tracker trackerStaticFieldLazyTestone = TrackerStaticFieldLazy.getInstance();
        Tracker trackerStaticFieldLazyTesttwo = TrackerStaticFieldLazy.getInstance();
        assertThat(trackerStaticFieldLazyTestone == trackerStaticFieldLazyTesttwo, is(true));
    }

    @Test
    public void whenEnum() {
        Tracker trackerEnumTestone = TrackerEnum.INSTANCE.getTracker();
        Tracker trackerEnumTesttwo = TrackerEnum.INSTANCE.getTracker();
        assertThat(trackerEnumTestone == trackerEnumTesttwo, is(true));
    }
}