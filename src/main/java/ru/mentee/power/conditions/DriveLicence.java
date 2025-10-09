package ru.mentee.power.conditions;

import java.util.Scanner;

public class DriveLicence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Ваш возраст: ");
        int age = scanner.nextInt();

        boolean isAdult = age >= 18;
        if(isAdult){
            System.out.println("Вы совершеннолетний!");
        } else {
            System.out.println("Вы несовершеннолетний!");
        }

        System.out.println("Есть ли у Вас водительские права? (true/false): ");
        boolean hasLicense = scanner.nextBoolean();

        if (isAdult && hasLicense){
            System.out.println("Поздравляем, Вы можете арендовать автомобиль!");
        }else{
            System.out.println("Извините, Вы не можете арендовать автомобиль!");
        }
        scanner.close();
    }
}
