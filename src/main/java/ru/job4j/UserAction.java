package ru.job4j;

import java.sql.SQLException;

public interface UserAction {
    String name();

    boolean execute(Input input, SqlTracker memTracker) throws SQLException;
    }
