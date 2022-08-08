package ru.job4j.tracker.store;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.model.Item;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 08/08/2022 - 21:47
 */
class HbmTrackerTest {

    @Test
    void whenAddNewItem() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    void whenReplace() {
        HbmTracker tracker = new HbmTracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName()).isEqualTo("Bug with description");
    }

    @Test
    void whenDelete() {
        HbmTracker tracker = new HbmTracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    void whenFindAll() {
        HbmTracker tracker = new HbmTracker();
        Item bug1 = new Item("Item1");
        Item bug2 = new Item("Item2");
        tracker.add(bug1);
        tracker.add(bug2);
        assertThat(List.of(bug1, bug2)).isEqualTo(tracker.findAll());
    }
}