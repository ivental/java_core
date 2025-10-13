package ru.mentee.power.conditions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SmartThermostatTest {
    private SmartThermostat thermostat;
    private static final double ERROR_TEMP = -100.0;

    @BeforeEach
    void setUp() {
        thermostat = new SmartThermostat();
    }

    @Test
    @DisplayName("Утро рабочего дня с присутствием людей")
    void getTargetTemperatureForWeekdayMorningOccupied() {
        int timeOfDay = 7;
        String dayOfWeek = "Вторник";
        boolean isOccupied = true;
        double outsideTemp = 15.0;
        double targetTemp = thermostat.getTargetTemperature(timeOfDay, dayOfWeek, isOccupied, outsideTemp);
        assertThat(targetTemp).isEqualTo(22.0);
    }

    @Test
    @DisplayName("Утро рабочего дня без присутствия людей")
    void getTargetTemperatureForWeekdayMorningUnoccupied() {
        int timeOfDay = 7;
        String dayOfWeek = "Вторник";
        boolean isOccupied = false;
        double outsideTemp = 15.0;
        double targetTemp = thermostat.getTargetTemperature(timeOfDay, dayOfWeek, isOccupied, outsideTemp);
        assertThat(targetTemp).isEqualTo(18.0);
    }

    @Test
    @DisplayName("День рабочего дня с присутствием людей")
    void getTargetTemperatureForWeekdayDayOccupied() {
        int timeOfDay = 14;
        String dayOfWeek = "Среда";
        boolean isOccupied = true;
        double outsideTemp = 20.0;
        double targetTemp = thermostat.getTargetTemperature(timeOfDay, dayOfWeek, isOccupied, outsideTemp);
        assertThat(targetTemp).isEqualTo(20.0);
    }

    @Test
    @DisplayName("Вечер рабочего дня с присутствием людей")
    void getTargetTemperatureForWeekdayEveningOccupied() {
        int timeOfDay = 20;
        String dayOfWeek = "Четверг";
        boolean isOccupied = true;
        double outsideTemp = 15.0;
        double targetTemp = thermostat.getTargetTemperature(timeOfDay, dayOfWeek, isOccupied, outsideTemp);
        assertThat(targetTemp).isEqualTo(22.0);
    }

    @Test
    @DisplayName("Ночь выходного дня без присутствия людей")
    void getTargetTemperatureForWeekendNightUnoccupied() {
        int timeOfDay = 2;
        String dayOfWeek = "Воскресенье";
        boolean isOccupied = false;
        double outsideTemp = 10.0;
        double targetTemp = thermostat.getTargetTemperature(timeOfDay, dayOfWeek, isOccupied, outsideTemp);
        assertThat(targetTemp).isEqualTo(16.0);
    }

    @Test
    @DisplayName("Энергосбережение при жаркой погоде")
    void applyEnergyRuleForHotWeather() {
        int timeOfDay = 14;
        String dayOfWeek = "Понедельник";
        boolean isOccupied = true;
        double outsideTemp = 28.0;
        double targetTemp = thermostat.getTargetTemperature(timeOfDay, dayOfWeek, isOccupied, outsideTemp);
        assertThat(targetTemp).isEqualTo(21.0);
    }

    @Test
    @DisplayName("Энергосбережение при холодной погоде")
    void applyEnergyRuleForColdWeather() {
        int timeOfDay = 23;
        String dayOfWeek = "Суббота";
        boolean isOccupied = true;
        double outsideTemp = -5.0;
        double targetTemp = thermostat.getTargetTemperature(timeOfDay, dayOfWeek, isOccupied, outsideTemp);
        assertThat(targetTemp).isEqualTo(21.0);
    }

    @Test
    @DisplayName("Обработка некорректного времени суток (меньше 0)")
    void handleInvalidTimeOfDayTooLow() {
        int timeOfDay = -1;
        String dayOfWeek = "Понедельник";
        boolean isOccupied = true;
        double outsideTemp = 15.0;
        double targetTemp = thermostat.getTargetTemperature(timeOfDay, dayOfWeek, isOccupied, outsideTemp);
        assertThat(targetTemp).isEqualTo(-100);
    }

    @Test
    @DisplayName("Обработка некорректного времени суток (больше 23)")
    void handleInvalidTimeOfDayTooHigh() {
        int timeOfDay = 24;
        String dayOfWeek = "Понедельник";
        boolean isOccupied = true;
        double outsideTemp = 15.0;
        double targetTemp = thermostat.getTargetTemperature(timeOfDay, dayOfWeek, isOccupied, outsideTemp);
        assertThat(targetTemp).isEqualTo(ERROR_TEMP);
    }

    @Test
    @DisplayName("Обработка некорректного дня недели")
    void handleInvalidDayOfWeek() {
        int timeOfDay = 10;
        String dayOfWeek = "Пятницааа";
        boolean isOccupied = false;
        double outsideTemp = 18.0;
        double targetTemp = thermostat.getTargetTemperature(timeOfDay, dayOfWeek, isOccupied, outsideTemp);
        assertThat(targetTemp).isEqualTo(-100.0);
    }

    @ParameterizedTest
    @CsvSource({
            "7, Понедельник, true, 15.0, 22.0",
            "7, Понедельник, false, 15.0, 18.0",
            "12, Среда, true, 28.0, 21.0",
            "20, Пятница, false, -2.0, 16.0",
            "8, Суббота, true, 10.0, 23.0",
            "15, Воскресенье, false, 30.0, 18.0",
            "23, Суббота, true, 15.0, 22.0",
            "3, Воскресенье, true, -5.0, 19.0"
    })
    @DisplayName("Разные комбинации времени, дней недели и присутствия")
    void getTargetTemperatureForVariousCombinations(int timeOfDay, String dayOfWeek,
                                                    boolean isOccupied, double outsideTemp,
                                                    double expectedTemp) {
        double targetTemp = thermostat.getTargetTemperature(timeOfDay, dayOfWeek, isOccupied, outsideTemp);
        assertThat(targetTemp).isEqualTo(expectedTemp);
    }
}

