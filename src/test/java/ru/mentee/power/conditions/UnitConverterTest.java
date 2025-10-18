package ru.mentee.power.conditions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;

class UnitConverterTest {

    private UnitConverter converter;
    private static final double DELTA = 0.001;
    private static final double ERROR = -1.0;

    @BeforeEach
    void setUp() {
        converter = new UnitConverter();
    }

    @Test
    @DisplayName("Конвертация из метров в сантиметры")
    void convertMetresToCentimetres() {
        double value = 1.0;
        String fromUnit = "Метр";
        String toUnit = "Сантиметр";
        double convertedValue = converter.convert(value, fromUnit, toUnit);
        assertThat(convertedValue).isCloseTo(100.0, within(DELTA));
    }

    @Test
    @DisplayName("Конвертация из сантиметров в метры")
    void convertCentimetresToMetres() {
        double value = 150.0;
        String fromUnit = "Сантиметр";
        String toUnit = "Метр";
        double convertedValue = converter.convert(value, fromUnit, toUnit);
        assertThat(convertedValue).isCloseTo(1.5, within(DELTA));
    }

    @Test
    @DisplayName("Конвертация из метров в футы")
    void convertMetresToFeet() {
        double value = 2.0;
        String fromUnit = "Метр";
        String toUnit = "Фут";
        double convertedValue = converter.convert(value, fromUnit, toUnit);
        assertThat(convertedValue).isCloseTo(6.56, within(DELTA));
    }

    @Test
    @DisplayName("Конвертация из килограммов в граммы")
    void convertKilogramsToGrams() {
        double value = 2.5;
        String fromUnit = "Килограмм";
        String toUnit = "Грамм";
        double convertedValue = converter.convert(value, fromUnit, toUnit);
        assertThat(convertedValue).isCloseTo(2500.0, within(DELTA));
    }

    @Test
    @DisplayName("Конвертация из фунтов в унции")
    void convertPoundsToOunces() {
        double value = 1.0;
        String fromUnit = "Фунт";
        String toUnit = "Унция";
        double convertedValue = converter.convert(value, fromUnit, toUnit);
        assertThat(convertedValue).isCloseTo(16.0, within(DELTA));
    }

    @Test
    @DisplayName("Конвертация из Цельсия в Фаренгейт")
    void convertCelsiusToFahrenheit() {
        double value = 25.0;
        String fromUnit = "Цельсий";
        String toUnit = "Фаренгейт";
        double convertedValue = converter.convert(value, fromUnit, toUnit);
        double expectedValue = (25.0 * 9.0 / 5.0) + 32.0;
        assertThat(convertedValue).isCloseTo(expectedValue, within(DELTA));
    }

    @Test
    @DisplayName("Конвертация из Фаренгейта в Кельвин")
    void convertFahrenheitToKelvin() {
        double value = 32.0;
        String fromUnit = "Фаренгейт";
        String toUnit = "Кельвин";
        double convertedValue = converter.convert(value, fromUnit, toUnit);
        assertThat(convertedValue).isCloseTo(273.15, within(DELTA));
    }

    @Test
    @DisplayName("Обработка несовместимых единиц измерения")
    void handleIncompatibleUnits() {
        double value = 10.0;
        String fromUnit = "Метр";
        String toUnit = "Килограмм";
        double result = converter.convert(value, fromUnit, toUnit);
        assertThat(result).isEqualTo(-1.0);
    }

    @Test
    @DisplayName("Обработка неподдерживаемых единиц измерения (fromUnit)")
    void handleUnsupportedFromUnit() {
        double value = 10.0;
        String fromUnit = "Миля";
        String toUnit = "Метр";
        double result = converter.convert(value, fromUnit, toUnit);

        assertThat(result).isEqualTo(-1.0);
    }

    @Test
    @DisplayName("Обработка неподдерживаемых единиц измерения (toUnit)")
    void handleUnsupportedToUnit() {
        double value = 10.0;
        String fromUnit = "Метр";
        String toUnit = "Ярд";
        double result = converter.convert(value, fromUnit, toUnit);
        assertThat(result).isEqualTo(ERROR);
    }

    @Test
    @DisplayName("Конвертация нулевого значения")
    void convertZero() {
        double value = 0.0;
        String fromUnit = "Метр";
        String toUnit = "Сантиметр";
        double result = converter.convert(value, fromUnit, toUnit);
        assertThat(result).isCloseTo(0.0, within(DELTA));
    }

    @Test
    @DisplayName("Конвертация очень большого значения")
    void convertVeryLarge() {
        double value = 1000000.0;
        String fromUnit = "Килограмм";
        String toUnit = "Грамм";
        double result = converter.convert(value, fromUnit, toUnit);
        assertThat(result).isCloseTo(1000000000.0, within(DELTA));
    }

    @Test
    @DisplayName("Конвертация очень маленького значения")
    void convertVerySmall() {
        double value = 0.001;
        String fromUnit = "Метр";
        String toUnit = "Сантиметр";
        double result = converter.convert(value, fromUnit, toUnit);
        assertThat(result).isCloseTo(0.1, within(DELTA));
    }

    @Test
    @DisplayName("Конвертация абсолютного нуля для Цельсия")
    void ablosuteZeroCelsium() {
        double value = 0.0;
        String fromUnit = "Цельсий";
        String toUnit = "Кельвин";
        double result = converter.convert(value, fromUnit, toUnit);
        assertThat(result).isCloseTo(273.15, within(DELTA));
    }

    @Test
    @DisplayName("Обработка null для fromUnit")
    void handleNullFromUnit() {
        double value = 5.0;
        String fromUnit = null;
        String toUnit = "Дюйм";
        double result = converter.convert(value, fromUnit, toUnit);
        assertThat(result).isCloseTo(-1.0, within(DELTA));
    }

    @Test
    @DisplayName("Обработка null для toUnit")
    void handleNullToUnit() {
        double value = 5.0;
        String fromUnit = "Дюйм";
        String toUnit = null;
        double result = converter.convert(value, fromUnit, toUnit);
        assertThat(result).isCloseTo(-1.0, within(DELTA));
    }

    @Test
    @DisplayName("Обработка невалидных данных fromUnit")
    void handleInvalidDataFromUnit() {
        double value = 5.0;
        String fromUnit = "Дюймовочка";
        String toUnit = "Сантиметр";
        double result = converter.convert(value, fromUnit, toUnit);
        assertThat(result).isCloseTo(-1.0, within(DELTA));
    }

    @Test
    @DisplayName("Обработка невалидных данных toUnit")
    void handleInvalidDataToUnit() {
        double value = 5.0;
        String fromUnit = "Дюйм";
        String toUnit = "Сантиметрус";
        double result = converter.convert(value, fromUnit, toUnit);
        assertThat(result).isCloseTo(-1.0, within(DELTA));
    }



    @ParameterizedTest
    @CsvSource({
            "1.0, Метр, Сантиметр, 100.0",
            "100.0, Сантиметр, Метр, 1.0",
            "1.0, Килограмм, Фунт, 2.20462",
            "1.0, Фунт, Килограмм, 0.45359",
            "0.0, Цельсий, Фаренгейт, 32.0",
            "273.15, Кельвин, Цельсий, 0.0",
            "5.0, Метр, Дюйм, 196.85",
            "10.0, Килограмм, Унция, 352.74"
    })
    @DisplayName("Различные конвертации")
    void testVariousConversions(double value, String fromUnit, String toUnit, double expected) {
        double convertedValue = converter.convert(value, fromUnit, toUnit);
        assertThat(convertedValue).isCloseTo(expected, within(DELTA));
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, Метр, Сантиметр, 0.0,",
            "1000000.0, Килограмм, Грамм, 1000000000.0",
            "0.001, Метр, Сантиметр, 0.1",
            "0.0, Цельсий, Кельвин, 273.15",
            "5.0, null, Дюйм, -1.0",
            "5.0, Дюйм, null, -1.0",
            "5.0, Дюймовочка, Сантиметр, -1.0",
            "5.0, Дюймов, Сантиметрус, -1.0",

    })
    @DisplayName("Различные конвертации доработка")
    void testVariousConversions1(double value, String fromUnit, String toUnit, double expected) {
        double convertedValue = converter.convert(value, fromUnit, toUnit);
        assertThat(convertedValue).isCloseTo(expected, within(DELTA));
    }
}

