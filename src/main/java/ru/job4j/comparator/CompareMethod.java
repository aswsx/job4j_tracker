package ru.job4j.comparator;

public class CompareMethod {

    public static int ascendingCompare(int first, int second) {
        return first < second ? -1 : second < first ? 1 : 0;
    }

    public static int descendingCompare(int first, int second) {
        return first > second ? -1 : second > first ? 1 : 0;
    }
}
