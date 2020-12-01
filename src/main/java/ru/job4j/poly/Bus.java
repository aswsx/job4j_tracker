package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
    }

    @Override
    public void passengers(int passengers) {
        passengers++;
    }

    @Override
    public int refuel(int fuelQty) {
        int price = 100;
        return fuelQty * price;
    }
}
