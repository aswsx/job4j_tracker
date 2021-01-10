package ru.job4j.lambda;

import java.util.Optional;

public class OptionalIfPresent {

    public static void ifPresent(int[] data) {
        max(data).ifPresent(x -> System.out.println("Max: " + x));
    }

    private static Optional<Integer> max(int[] data) {
        if (data.length != 0) {
            int max = data[0];
            for (int i = 1; i < data.length; i++) {
                if (max < data[i]) {
                    max = data[i];
                }
            }
            return Optional.of(max);
        } else {
            return Optional.empty();
        }
    }
}
