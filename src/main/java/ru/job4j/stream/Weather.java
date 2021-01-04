package ru.job4j.stream;

public class Weather {
    private double temperature;
    private double humidity;
    private double wind;
    private String clouds;
    private String season;
    private String position;

    @Override
    public String toString() {
        return String.format(
                 "Position: " + this.position + "%n"
                + "Season: " + this.season + "%n"
                + "Temperature: " + this.temperature + "%n"
                + "Humidity: " + this.humidity + "%n"
                + "Wind: " + this.wind + "%n"
                + "Clouds: " + this.clouds
        );
    }

    static class Builder {
        private double temperature;
        private double humidity;
        private double wind;
        private String clouds;
        private String season;
        private String position;

        Builder buildTemperature(double temperature) {
            this.temperature = temperature;
            return this;
        }

        Builder buildHumidity(double humidity) {
            this.humidity = humidity;
            return this;
        }

        Builder buildWind(double wind) {
            this.wind = wind;
            return this;
        }

        Builder buildClouds(String clouds) {
            this.clouds = clouds;
            return this;
        }

        Builder buildSeason(String season) {
            this.season = season;
            return this;
        }

        Builder buildPosition(String position) {
            this.position = position;
            return this;
        }

        Weather build() {
            Weather weather = new Weather();
            weather.temperature = temperature;
            weather.humidity = humidity;
            weather.wind = wind;
            weather.clouds = clouds;
            weather.season = season;
            weather.position = position;
            return weather;
        }
    }

    public static void main(String[] args) {
        Weather weather = new Builder()
                .buildPosition("Nur-Sultan")
                .buildSeason("Winter")
                .buildTemperature(-28)
                .buildHumidity(43)
                .buildWind(18)
                .buildClouds("Clear")
                .build();
        System.out.println(weather);
    }
}
