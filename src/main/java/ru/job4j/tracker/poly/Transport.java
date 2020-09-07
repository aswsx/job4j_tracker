package ru.job4j.tracker.poly;

public interface Transport {
    void drive();

    void passengers(int passengers);

    int refuel(int fuelQty);
}
