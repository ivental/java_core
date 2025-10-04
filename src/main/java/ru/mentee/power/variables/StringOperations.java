package ru.mentee.power.variables;

public class StringOperations {
    public static void main(String[] args) {
        String firstName = "ILIA";
        String secondName = "IUKIN";
        String numberStr = "1000000";
        char charA = 'A';
        int age = 100;


        String fullName = firstName + " " + secondName;   // Конкатенация строк
        String stringS = String.valueOf(charA);  // Преобразование символа в строку
        String numberString = String.valueOf(age); // Преобразование числа в строку
        int numberInt = Integer.parseInt(numberStr);  // Преобразование строки в число
        char extraction = firstName.charAt(1);  // Извлечение символа из строки

        System.out.println("Concatenation = " + fullName);  // Конкатенация строк
        System.out.println("Character to string conversion = " + stringS); // Преобразование символа в строку
        System.out.println("Number to string conversion = " + numberString); // Преобразование числа в строку
        System.out.println("String to number conversion = " + numberInt); // Преобразование строки в число
        System.out.println("Extracted character = " + extraction); // Извлечение символа из строки







    }
}
