package ru.job4j.tracker.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 08/08/2022 - 21:34
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public City(String name) {
        this.name = name;
    }
}