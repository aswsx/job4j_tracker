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
        try (PreparedStatement statement = connection
                .prepareStatement("Insert into items (?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) throws SQLException {
        var result = false;
        try (PreparedStatement statement = connection
                .prepareStatement("Replace item = ? with id = ?")) {
            statement.setString(1, item.getName());
            statement.setInt(2, id);
            result = statement.executeUpdate() > 0;
        }
        return result;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        var result = false;
        try (PreparedStatement statement = connection
                .prepareStatement("Delete item with id = ? ")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
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
        var sql = String.format("select * from items where name='%s'", key);
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
        var sql = String.format("select * from items where id='%d'", id);
        Item item = null;
        ResultSet rsl;
        try (var statement = connection.createStatement()) {
            statement.execute(sql);
            rsl = statement.getResultSet();
            rsl.next();
            item = new Item(rsl.getInt("id"), rsl.getString("name"));
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return item;
    }
}