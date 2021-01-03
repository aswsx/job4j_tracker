package ru.job4j.stream;

public class Profile {
    private final Address address;

    Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}

