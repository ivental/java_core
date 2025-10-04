package ru.mentee.power.variables;

public class TemperatureConverter {
    public static final double ABSOLUTE_ZERO_CELSIUS = -273.15;
    public static final double ABSOLUTE_ZERO_KELVIN = 0;
    public static final double ABSOLUTE_ZERO_FAHRENHEIT = -459.67;

    public static void main(String[] args) {
        double temperatureCelsius = 50.5;
        double temperatureKelvin = 4.5;
        double temperatureFahrenheit = 3.6;

        // Цельсий в Фаренгейт: (C × 9/5) + 32
        double celsiusToFahrenheit = (temperatureCelsius * 9 / 5) + 32;
        // Фаренгейт в Цельсий: (F − 32) × 5/9
        double fahrenheitToCelsius = (temperatureFahrenheit - 32) * 5 / 9;
        // Цельсий в Кельвин: C + 273.15(Абсолютный ноль по Цельсию)
        double celsiusToKelvin = temperatureCelsius - ABSOLUTE_ZERO_CELSIUS; //
        // Кельвин в Цельсий: C - 273.15(Абсолютный ноль по Цельсию)
        double kelvinToCelsius = temperatureKelvin + ABSOLUTE_ZERO_CELSIUS;

        System.out.println("Celsius to Fahrenheit: " + celsiusToFahrenheit);
        System.out.println("Fahrenheit to Celsius: " + fahrenheitToCelsius);
        System.out.println("Celsius to Kelvin: " + celsiusToKelvin);
        System.out.println("Kelvin to Celsius: " + kelvinToCelsius);
    }
}
