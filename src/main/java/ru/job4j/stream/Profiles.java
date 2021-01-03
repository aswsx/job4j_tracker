package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    private final Address address;

    Profiles(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    List<Address> collect(List<Profiles> profiles) {
        return profiles.stream()
                .map(Profiles::getAddress)
                .collect(Collectors.toList());

    }
}

