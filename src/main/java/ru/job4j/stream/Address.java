package ru.job4j.stream;

import java.util.Objects;

public class Address {
    private final String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return city.equals(address.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }
}