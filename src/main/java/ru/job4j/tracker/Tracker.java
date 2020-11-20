package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
   // private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean isReplaced = index != -1;
        if (isReplaced) {
            item.setId(id);
            items.set(index, item);
        }
        return isReplaced;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean isDeleted = index != -1;
        if (isDeleted) {
            items.remove(index);
          //  items.set(size - 1, null);
          //  size--;
        }
        return isDeleted;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> rsl = new ArrayList<>();
       // int newSize = 0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }
}
