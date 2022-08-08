package ru.job4j.tracker.store;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.model.City;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 08/08/2022 - 21:40
 */
class CityStoreTest {

    @Test
    void whenCreate() {
        CityStore cityStore = new CityStore();
        City city = new City("Moscow");
        cityStore.create(city);
        List<City> all = cityStore.findAll();
        assertThat(city).isEqualTo(all.get(0));
    }

    @Test
    void whenFindAll() {
        CityStore cityStore = new CityStore();
        City city1 = new City("Moscow");
        City city2 = new City("St. Petersburg");
        cityStore.create(city1);
        cityStore.create(city2);
        assertThat(List.of(city1, city2)).isEqualTo(cityStore.findAll());
    }

}