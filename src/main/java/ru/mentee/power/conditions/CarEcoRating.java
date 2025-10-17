package ru.mentee.power.conditions;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarEcoRating {
    private static final int ERROR_CODE = -1;
    private static final int MIN_RATING = 1;
    private static final int MAX_RATING = 100;
    private static final int EURO_STANDARD_YEAR_THRESHOLD = 2020; // Замените на корректное значение
    private static final int BASE_RATING_ELECTRIC = 90;
    private static final int BASE_RATING_HYBRID = 70;
    private static final int BASE_RATING_DIESEL = 40;
    private static final int BASE_RATING_PETROL = 30;
    private static final List<String> VALID_FUEL_TYPES = Arrays.asList("Бензин", "Дизель", "Гибрид", "Электро",
            "бензин", "дизель", "гибрид", "электро");

    public int calculateEcoRating(String fuelType, double engineVolume,
                                  double fuelConsumption, int yearOfManufacture,
                                  boolean isEuroCompliant) {
        int targetRating;
        if (!validateInput(fuelType, engineVolume, fuelConsumption, yearOfManufacture)) {
            return ERROR_CODE;
        }
        targetRating = applyRatingModifiers(getBaseFuelTypeRating(fuelType), fuelType, engineVolume, fuelConsumption,
                yearOfManufacture, isEuroCompliant);
        return targetRating;
    }


    private boolean validateInput(String fuelType, double engineVolume,
                                  double fuelConsumption, int yearOfManufacture) {
        if (fuelType == null || !VALID_FUEL_TYPES.contains(fuelType) || engineVolume < 0 || fuelConsumption < 0
                || yearOfManufacture > LocalDate.now().getYear()) {
            return false;
        }
        if ("Электро".equalsIgnoreCase(fuelType) && engineVolume != 0) {
            return false;
        }
        return true;
    }

    private int getBaseFuelTypeRating(String fuelType) {
        if (fuelType == null) {
            return ERROR_CODE;
        }

        switch (fuelType) {
            case "Бензин", "бензин":
                return BASE_RATING_PETROL;
            case "Дизель", "дизель":
                return BASE_RATING_DIESEL;
            case "Гибрид", "гибрид":
                return BASE_RATING_HYBRID;
            case "Электро", "электро":
                return BASE_RATING_ELECTRIC;
            default:
                return ERROR_CODE;
        }
    }


    private int applyRatingModifiers(int baseRating, String fuelType, double engineVolume,
                                     double fuelConsumption, int yearOfManufacture,
                                     boolean isEuroCompliant) {
        double tempRating = baseRating;
        double volumePenalty = 0;
        double consumtionPenalty = 0;
        double yearPenalty = 0;

        if ("Бензин".equalsIgnoreCase(fuelType) || "Дизель".equalsIgnoreCase(fuelType) ||
                "Гибрид".equalsIgnoreCase(fuelType)) {
            volumePenalty = engineVolume * 5;
            tempRating -= volumePenalty;
            consumtionPenalty = fuelConsumption * 2;
            tempRating -= consumtionPenalty;
        }
        if (isEuroCompliant && ("Бензин".equalsIgnoreCase(fuelType) || "Дизель".equalsIgnoreCase(fuelType)
        || "Гибрид".equalsIgnoreCase(fuelType))) {
            tempRating += 10;
        }
        if ("Гибрид".equalsIgnoreCase(fuelType) && fuelConsumption < 5) {
            tempRating += 15;
        }
        if ("Электро".equalsIgnoreCase(fuelType)) {
            tempRating -= fuelConsumption * 0.5;
        }
        if (yearOfManufacture < EURO_STANDARD_YEAR_THRESHOLD) {
            yearPenalty = (EURO_STANDARD_YEAR_THRESHOLD - yearOfManufacture) * 1;
            tempRating -= yearPenalty;
        }
        return clampRating((int) Math.round(tempRating));
    }


    private int clampRating(int rating) {
        return Math.min(MAX_RATING, Math.max(MIN_RATING, rating));
    }

    public static void main(String[] args) {
        CarEcoRating ecoRating = new CarEcoRating();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какой тип топлива у автомобиля: ");
        String fuelType = scanner.next();
        System.out.println("Какой объём двигателя у автомобиля: ");
        double engineVolume = scanner.nextDouble();
        System.out.println("Какой расход топлива у автомобиля в литрах: ");
        double fuelConsumption = scanner.nextDouble();
        System.out.println("Какой год выпуска автомобиля: ");
        int yearOfManufacture = scanner.nextInt();
        System.out.println("Соответствует ли автомобиль стандарту Евро-6(true/false): ");
        boolean isEuroCompilant = scanner.nextBoolean();
        int result = ecoRating.calculateEcoRating(fuelType, engineVolume, fuelConsumption, yearOfManufacture,
                isEuroCompilant);
        if (result == ERROR_CODE) {
            System.out.println("Введены неверные данные: ");
        } else {
            System.out.println("Рейтинг экологичности вашего автомобиля (от 1 до 100) равен: " + result);
        }
        scanner.close();
    }
}


