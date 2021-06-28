package ru.job4j;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            var config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) throws SQLException {
        Item rsl = null;
        var sql = String.format("Insert into items values '%s';", item);
        try (var statement = connection.createStatement()) {
            if (statement.execute(sql)) {
                rsl = item;
            }
        }
        return rsl;
    }

    @Override
    public boolean replace(int id, Item item) throws SQLException {
        var sql = String.format("update items name='%s' where id='%s';", item.getName(), id);
        var result = false;
        try (var statement = connection.createStatement()) {
            result = statement.execute(sql);
        }
        return result;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        var sql = String.format("delete from items where id='%s';", id);
        var result = false;
        try (var statement = connection.createStatement()) {
            result = statement.execute(sql);
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        var sql = "select * from items";
        List<Item> list = new ArrayList<>();
        ResultSet rsl;
        try (var statement = connection.createStatement()) {
            statement.execute(sql);
            rsl = statement.getResultSet();
            while (rsl.next()) {
                list.add(new Item(rsl.getInt("id"), rsl.getString("name")));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        var sql = String.format("select * from items where name='%s';", key);
        List<Item> list = new ArrayList<>();
        ResultSet rsl;
        try (var statement = connection.createStatement()) {
            statement.execute(sql);
            rsl = statement.getResultSet();
            while (rsl.next()) {
                list.add(new Item(rsl.getInt("id"), rsl.getString("name")));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        var sql = String.format("select * from items where id='%d';", id);
        Item item = null;
        ResultSet rsl;
        try (var statement = connection.createStatement()) {
            statement.execute(sql);
            rsl = statement.getResultSet();
            if (rsl.next()) {
                item = new Item(rsl.getInt("id"), rsl.getString("name"));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return item;
    }
}