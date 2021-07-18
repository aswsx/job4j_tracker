package ru.job4j.store;

import ru.job4j.model.Item;

import java.sql.SQLException;
import java.util.List;

public interface Store extends AutoCloseable {
    void init();

    Item add(Item item) throws SQLException;

    boolean replace(int id, Item item) throws SQLException;

    boolean delete(int id) throws SQLException;

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(int id);
}