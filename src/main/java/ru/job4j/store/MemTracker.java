package ru.job4j.store;

import ru.job4j.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    @Override
    public void init() {
    }

    @Override
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    @Override
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (var index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    @Override
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean isReplaced = index != -1;
        if (isReplaced) {
            item.setId(id);
            items.set(index, item);
        }
        return isReplaced;
    }

    @Override
    public boolean delete(int id) {
        int index = indexOf(id);
        boolean isDeleted = index != -1;
        if (isDeleted) {
            items.remove(index);
        }
        return isDeleted;
    }

    @Override
    public List<Item> findAll() {
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    @Override
    public void close() {
    }
}
