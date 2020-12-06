package ru.job4j.map;

import java.util.*;

public class Weather {
    public static List<Info> editData(List<Info> list) {
        List<Info> rsl = new ArrayList<>();
        Map<String, Integer> city = new HashMap<>();
        for (Info elem : list) {
            city.computeIfPresent(elem.getCity(), (key, val) -> val + elem.getRainfall());
            city.putIfAbsent(elem.getCity(), elem.getRainfall());
        }
        for (String str : city.keySet()) {
            rsl.add(new Info(str, city.get(str)));
        }
        return rsl;
    }

    public static class Info {
        private final String city;

        private final int rainfall;

        public Info(String city, int rainfall) {
            this.city = city;
            this.rainfall = rainfall;
        }

        public String getCity() {
            return city;
        }

        public int getRainfall() {
            return rainfall;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return rainfall == info.rainfall
                    && Objects.equals(city, info.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, rainfall);
        }
    }
}