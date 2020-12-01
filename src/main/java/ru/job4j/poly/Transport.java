package ru.job4j.poly;

public interface Transport {
    void drive();

    void passengers(int passengers);

    int refuel(int fuelQty);
}
