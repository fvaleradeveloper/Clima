

import java.util.List;

public class WeatherResponse {
    private Coord coord;
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private String name;

    // Getters y Setters omitidos por brevedad

    public static class Coord {
        private double lon;
        private double lat;

        // Getters y Setters
    }

    public static class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;

        // Getters y Setters
    }

    public static class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int humidity;

        // Getters y Setters
    }

    public static class Wind {
        private double speed;
        private int deg;

        // Getters y Setters
    }
}