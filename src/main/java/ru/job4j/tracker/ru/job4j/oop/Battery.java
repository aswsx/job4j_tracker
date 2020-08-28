package ru.job4j.tracker.ru.job4j.oop;

public class Battery {

    private int level;

    public Battery(int level) {
        this.level = level;
    }

    public void pour(Battery another) {
        this.level = this.level + another.level;
        another.level = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(80);
        Battery second = new Battery(15);
        System.out.println("first : " + first.level + ". second : " + second.level);
        first.pour(second);
        System.out.println("first : " + first.level + ". second : " + second.level);
    }
}
