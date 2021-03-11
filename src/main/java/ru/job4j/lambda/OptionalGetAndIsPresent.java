package ru.job4j.lambda;

import java.util.Optional;

public class OptionalGetAndIsPresent {

    public static int get(int[] data, int el) {
        return OptionalGetAndIsPresent.indexOf(data, el)
                .isPresent()
                ? OptionalGetAndIsPresent
                .indexOf(data, el).get() : -1;

    }

    private static Optional<Integer> indexOf(int[] data, int el) {
        if (data.length != 0) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] == el) {
                    return Optional.of(i);
                }
            }
        }
        return Optional.empty();
    }
}



