package ru.job4j.map;

import java.util.Map;
import java.util.Objects;

public class Farm {
    public static int sumLegs(Map<Animal, Integer> data) {
        int legs = 0;
        for (Animal animal : data.keySet()) {
            legs += animal.getLegs() * data.get(animal);
        }
        return legs;
    }

    public static class Animal {
        private final String name;

        private final int legs;

        public Animal(String name, int legs) {
            this.name = name;
            this.legs = legs;
        }

        public String getName() {
            return name;
        }

        public int getLegs() {
            return legs;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Animal animal = (Animal) o;
            return Objects.equals(name, animal.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}