package ru.job4j.lambda;

import java.util.List;
import java.util.Optional;

public class OptionalOfAndEmpty {
    public static Optional<String> findValue(List<String> strings, String value) {
        Optional<String> stringRsl = Optional.empty();
        for (String string : strings) {
            if (string.equals(value)) {
                stringRsl = Optional.of(value);
                break;
            }
        }
        return stringRsl;
    }
}