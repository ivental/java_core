package ru.mentee.power.conditions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class UnitConverter {
    private static final double ERROR_CODE = -1.0;
    private static final List<String> LENGTH_UNITS = Arrays.asList("Метр", "Сантиметр", "Дюйм",
            "Фут");
    private static final List<String> WEIGHT_UNITS = Arrays.asList("Килограмм", "Грамм", "Фунт", "Унция");
    private static final List<String> TEMP_UNITS = Arrays.asList("Цельсий", "Фаренгейт", "Кельвин");


    public double convert(double value, String fromUnit, String toUnit) {
        if (getCategory(fromUnit) == null || getCategory(toUnit) == null) {
            return ERROR_CODE;
        }
        if (!areSameCategory(fromUnit, toUnit)) {
            return ERROR_CODE;
        }
        if (getCategory(fromUnit).equals("Длина")) {
            return convertLength(value, fromUnit, toUnit);
        }
        if (getCategory(fromUnit).equals("Вес")) {
            return convertWeight(value, fromUnit, toUnit);
        }
        if (getCategory(fromUnit).equals("Температура")) {
            return convertTemperature(value, fromUnit, toUnit);
        } else {
            return ERROR_CODE;
        }
    }


    private boolean areSameCategory(String unit1, String unit2) {
        String category1 = getCategory(unit1);
        String category2 = getCategory(unit2);
        if (category1 != null && category2 != null && category1.equals(category2)) {
            return true;
        } else {
            return false;
        }
    }

    private String getCategory(String unit) {
        if (LENGTH_UNITS.contains(unit)) {
            return "Длина";
        } else if (WEIGHT_UNITS.contains(unit)) {
            return "Вес";
        } else if (TEMP_UNITS.contains(unit)) {
            return "Температура";
        } else {
            return null;
        }
    }

    private double convertLength(double value, String fromUnit, String toUnit) {
        double valueInMeters;
        switch (fromUnit) {
            case "Метр":
                valueInMeters = value * 1;
                break;
            case "Сантиметр":
                valueInMeters = value / 100;
                break;
            case "Фут":
                valueInMeters = value / 3.28;
                break;
            case "Дюйм":
                valueInMeters = value / 39.37;
                break;
            default:
                return ERROR_CODE;
        }
        switch (toUnit) {
            case "Метр":
                return valueInMeters;
            case "Сантиметр":
                return valueInMeters * 100;
            case "Фут":
                return valueInMeters * 3.28;
            case "Дюйм":
                return valueInMeters * 39.37;
            default:
                return ERROR_CODE;
        }
    }

    private double convertWeight(double value, String fromUnit, String toUnit) {
        double valueInKg;
        switch (fromUnit) {
            case "Килограмм":
                valueInKg = value * 1;
                break;
            case "Грамм":
                valueInKg = value * 0.001;
                break;
            case "Фунт":
                valueInKg = value * 0.453592;
                break;
            case "Унция":
                valueInKg = value * 0.0283495;
                break;
            default:
                return ERROR_CODE;
        }
        switch (toUnit) {
            case "Килограмм":
                return valueInKg;
            case "Грамм":
                return valueInKg / 0.001;
            case "Фунт":
                return valueInKg / 0.453592;
            case "Унция":
                return valueInKg / 0.0283495;
            default:
                return ERROR_CODE;
        }
    }

    private double convertTemperature(double value, String fromUnit, String toUnit) {
        double targetTemperature;
        String targetS = fromUnit + " в " + toUnit;
        if (fromUnit.equals(toUnit)) {
            return value;
        }
        switch (targetS) {
            case "Цельсий в Фаренгейт":
                targetTemperature = value * 1.8 + 32;
                break;
            case "Фаренгейт в Цельсий":
                targetTemperature = (value - 32) * 5.0 / 9.0;
                break;
            case "Цельсий в Кельвин":
                targetTemperature = value + 273.15;
                break;
            case "Кельвин в Цельсий":
                targetTemperature = value - 273.15;
                break;
            case "Кельвин в Фаренгейт":
                targetTemperature = (value - 273.15) * 1.8 + 32;
                break;
            case "Фаренгейт в Кельвин":
                targetTemperature = (value + 459.67) * 5.0 / 9.0;
                break;
            default:
                return ERROR_CODE;
        }
        return targetTemperature;
    }

    public static void main(String[] args) {
        UnitConverter converter = new UnitConverter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение:");
        double value = scanner.nextDouble();
        System.out.println("Введите исходную единицу:");
        String fromUnit = scanner.next();
        System.out.println("Введите целевую единицу:");
        String toUnit = scanner.next();
        double result = converter.convert(value, fromUnit, toUnit);
        if (result == ERROR_CODE) {
            System.out.println("Ошибка конвертации: ");
        } else {
            System.out.println("Результат: " + result);
        }
    }
}







