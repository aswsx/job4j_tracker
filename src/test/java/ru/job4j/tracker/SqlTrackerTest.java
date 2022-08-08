package ru.job4j.tracker;

import org.junit.*;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.SqlTracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
@Ignore
public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (var in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
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

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (var statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        var tracker = new SqlTracker(connection);
        var item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSaveItemThenDeleteAndFindByGeneratedIdThenMustBeNull() {
        var tracker = new SqlTracker(connection);
        var item = new Item();
        tracker.add(item);
        assertTrue(tracker.delete(item.getId()));
    }

    @Test
    public void whenAddItemsAndFindAllTheNamesMustBeTheSame() {
        var tracker = new SqlTracker(connection);
        tracker.add(new Item("item1"));
        tracker.add(new Item("item2"));
        var rsl = tracker.findAll();
        for (var i = 0; i < rsl.size(); i++) {
            assertEquals(String.format("item%d", (i + 1)), rsl.get(i).getName());
        }
    }

    @Test
    public void whenAddItemThenFindItByIdNameMustBeTheSame() {
        var tracker = new SqlTracker(connection);
        var item = new Item("item");
        tracker.add(item);
        var rsl = tracker.findById(item.getId());
        assertEquals(rsl.getName(), item.getName());
    }

    @Test
    public void whenAddItemAndThenReplaceTheNameMastBeChanged() {
        var tracker = new SqlTracker(connection);
        var item = new Item("item");
        tracker.add(item);
        item.setName("newItem");
        tracker.replace(item.getId(), item);
        assertEquals("newItem", tracker.findById(item.getId()).getName());
    }

    @Test
    public void whenAddItemsThenFindItByName() {
        var tracker = new SqlTracker(connection);
        tracker.add(new Item(0, "item1"));
        tracker.add(new Item(0, "item2"));
        tracker.add(new Item(0, "item1"));
        var rsl = tracker.findByName("item1");
        assertEquals(2, rsl.size());
        for (var item : rsl) {
            assertEquals("item1", item.getName());
        }
    }
}