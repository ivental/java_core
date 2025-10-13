package ru.mentee.power.conditions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SmartThermostat {
    private static final double ERROR_TEMP_CODE = -100.0;
    private final static int MIN_TIME_OF_DAY = 0;
    private final static int MAX_TIME_OF_DAY = 23;
    private static final List<String> WEEKDAYS = Arrays.asList("Понедельник", "Вторник", "Среда", "Четверг", "Пятница",
            "понедельник", "вторник", "среда", "четверг", "пятница");
    private static final List<String> WEEKENDS = Arrays.asList("Суббота", "Воскресенье", "суббота", "воскресенье");


    public double getTargetTemperature(int timeOfDay, String dayOfWeek, boolean isOccupied,
                                       double currentOutsideTemperature) {

        if (timeOfDay < MIN_TIME_OF_DAY || timeOfDay > MAX_TIME_OF_DAY) {
            return ERROR_TEMP_CODE;
        }
        if (!WEEKDAYS.contains(dayOfWeek) && !WEEKENDS.contains(dayOfWeek)) {
            return ERROR_TEMP_CODE;
        }
        int targetTemperature = 0;

        if (WEEKDAYS.contains(dayOfWeek)) {
            if (timeOfDay >= 6 && timeOfDay <= 8) {
                if (isOccupied) {
                    targetTemperature = 22;
                } else {
                    targetTemperature = 18;
                }
            } else if (timeOfDay >= 9 && timeOfDay <= 17) {
                if (isOccupied) {
                    targetTemperature = 20;
                } else {
                    targetTemperature = 16;
                }
            } else if (timeOfDay >= 18 && timeOfDay <= 22) {
                if (isOccupied) {
                    targetTemperature = 22;
                } else {
                    targetTemperature = 17;
                }
            } else if (timeOfDay >= 23 || timeOfDay <= 5) {
                if (isOccupied) {
                    targetTemperature = 19;
                } else {
                    targetTemperature = 16;
                }
            }
        }
        if (WEEKENDS.contains(dayOfWeek)) {
            if (timeOfDay >= 7 && timeOfDay <= 9) {
                if (isOccupied) {
                    targetTemperature = 23;
                } else {
                    targetTemperature = 18;
                }
            } else if (timeOfDay >= 10 && timeOfDay <= 17) {
                if (isOccupied) {
                    targetTemperature = 22;
                } else {
                    targetTemperature = 17;
                }
            } else if (timeOfDay >= 18 && timeOfDay <= 23) {
                if (isOccupied) {
                    targetTemperature = 22;
                } else {
                    targetTemperature = 17;
                }
            } else if (timeOfDay >= 0 && timeOfDay <= 6) {
                if (isOccupied) {
                    targetTemperature = 20;
                } else {
                    targetTemperature = 16;
                }
            }
        }
        if (currentOutsideTemperature > 25) {
            targetTemperature = targetTemperature + 1;
        } else if (currentOutsideTemperature < 0) {
            targetTemperature = targetTemperature - 1;
        } else {
        }
        return targetTemperature;
    }


    public static void main(String[] args) {
        SmartThermostat thermostat = new SmartThermostat();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите время суток (0-23): ");
        int timeOfDay = scanner.nextInt();
        System.out.println("Введите день недели: ");
        String dayOfWeek = scanner.next();
        System.out.println("На данный момент есть ли кто-то в доме(true/false): ");
        boolean isOccupied = scanner.nextBoolean();
        System.out.println("Какая текущая температура на улице: ");
        double currentOutsideTemperature = scanner.nextDouble();
        double targetTemp = thermostat.getTargetTemperature(timeOfDay, dayOfWeek, isOccupied, currentOutsideTemperature);
        if (targetTemp == ERROR_TEMP_CODE) {
            System.out.println("Ошибка! Введены некорректные данные, попробуйте ввести заново!");
        } else {
            System.out.println("Рекомендуемая температура: " + targetTemp + "°C");
        }
    }
}






