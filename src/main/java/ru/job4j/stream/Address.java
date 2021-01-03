package ru.job4j.stream;

import java.util.Objects;

public class Address {
    private final String city;
    private final String street;
    private final int home;
    private final int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
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
        return city.equals(address.getCity()) && street.equals(address.getStreet())
                && home == address.getHome() && apartment == address.getApartment();
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }
}