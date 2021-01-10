package ru.job4j.collection;

public class Parentheses {
    public static boolean valid(char[] data) {
        int sum = 0;
        for (char datum : data) {
            sum += datum == '(' ? 1 : -1;
            if (sum < 0) {
                break;
            }
        }
        return sum == 0;
    }
}
