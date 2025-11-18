package ru.mentee.power.methods.recursion;
import java.util.Arrays;

public class RecursionDemo {
    public static void main(String[] args) {
        System.out.println("=== Факториал ===");
        System.out.println("5! = " + RecursionExercises.factorial(5));

        System.out.println("\n=== Числа Фибоначчи ===");
        System.out.println("Наивная реализация:");
        for (int i = 0; i <= 10; i++) {
            System.out.print(RecursionExercises.fibonacci(i) + " ");
        }

        System.out.println("\nОптимизированная реализация:");
        for (int i = 0; i <= 10; i++) {
            System.out.print(RecursionExercises.fibonacciOptimized(i) + " ");
        }

        System.out.println("\n\n=== Проверка палиндрома ===");
        String[] testString = {"А роза упала на лапу Азора"};

        System.out.println(RecursionExercises.isPalindrome(Arrays.toString(testString)));
        System.out.println("\n=== Сумма цифр ===");
        System.out.println(RecursionExercises.sumOfDigits(12345));

        System.out.println("\n=== Возведение в степень ===");
        System.out.println(RecursionExercises.power(2, 10));
        System.out.println(RecursionExercises.power(2, -3));

        System.out.println("\n=== Наибольший общий делитель ===");
        System.out.println(RecursionExercises.gcd(48, 36));

        System.out.println("\n=== Обращение массива ===");
        int[] arrayTest = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Массив" + Arrays.toString(arrayTest));
        RecursionExercises.reverseArray(arrayTest,0,6);
        System.out.println("в перевернутом виде выглядит так: " + Arrays.toString(arrayTest));
    }
}
