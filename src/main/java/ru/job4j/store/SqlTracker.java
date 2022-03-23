package ru.job4j.store;

import ru.job4j.model.Item;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    public SqlTracker() {
    }

    @Override
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
    public Item add(Item item) {
        var sql = "Insert into items(name) values (?)";
        try (var statement = connection.prepareStatement(sql, Statement
                .RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        var rsl = false;
        var sql = "update items set name = ? where id = ?";
        try (var statement = connection.prepareStatement(sql)) {
            statement.setString(1, item.getName());
            statement.setInt(2, id);
            rsl = statement.executeUpdate() > 0;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        var sql = "delete from items where id = ?";
        var result = false;
        try (var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        var sql = "select * from items";
        List<Item> list = new ArrayList<>();
        try (var statement = connection.prepareStatement(sql)) {
            try (var resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            Timestamp.valueOf(LocalDateTime.now())));
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        var sql = "select * from items where name=?";
        List<Item> list = new ArrayList<>();
        try (var statement = connection.prepareStatement(sql)) {
            statement.setString(1, key);
            try (var resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            Timestamp.valueOf(LocalDateTime.now())));
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        var sql = "select * from items where id=?";
        Item item = null;
        try (var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (var resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    item = new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"), Timestamp
                            .valueOf(LocalDateTime.now()));
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return item;
    }
}