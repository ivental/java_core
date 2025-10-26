package ru.mentee.power.loop;
import java.util.HashMap;
import java.util.Map;

public class FibonacciCalculator {
    private final Map<Integer, Long> cache = new HashMap<>();

    public long fibonacciRecursive(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }



    public long fibonacciIterative(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        long prev = 0;
        long current = 1;

        for (int i = 2; i <= n; i++) {
            long next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }

    public long fibonacciWithCache(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        long result = fibonacciWithCache(n - 1) + fibonacciWithCache(n - 2);
        cache.put(n, result);

        return result;

    }


    public long[] generateFibonacciSequence(int n) {
        if (n < 0) return new long[0];
        long[] fibonacciSequence = new long[n];

        if (n == 0) {
            return fibonacciSequence;
        }
        if (n == 1) {
            fibonacciSequence[0] = 0;
            return fibonacciSequence;
        }
        if (n == 2) {
            fibonacciSequence[0] = 0;
            fibonacciSequence[1] = 1;
            return fibonacciSequence;
        }
        if (n > 2) {
            fibonacciSequence[0] = 0;
            fibonacciSequence[1] = 1;
            for (int i = 2; i < n; i++) {
                fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
            }
        }
        return fibonacciSequence;
    }


    public boolean isFibonacciNumber(long number) {
        if (number == 0 || number == 1) {
            return true;
        }
        if (number < 0) {
            return false;
        }
        long numberSqrt = number * number * 5;
        long numberCheck = numberSqrt + 4;
        long numberCheck1 = numberSqrt - 4;
        long root = (long) Math.sqrt(numberCheck);
        long root1 = (long) Math.sqrt(numberCheck1);
        if (root * root == numberCheck) {
            return true;
        }
        if (root1 * root1 == numberCheck1) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        FibonacciCalculator calculator = new FibonacciCalculator();

        System.out.println("Последовательность Фибоначчи (первые 10 чисел):");
        long[] sequence = calculator.generateFibonacciSequence(10);
        for (int i = 0; i < sequence.length; i++) {
            System.out.println("F(" + i + ") = " + sequence[i]);
        }

        System.out.println("\nПроверка различных методов вычисления F(10):");
        System.out.println("Рекурсивный метод: " + calculator.fibonacciRecursive(10));
        System.out.println("Итеративный метод: " + calculator.fibonacciIterative(10));
        System.out.println("Метод с кэшированием: " + calculator.fibonacciWithCache(10));

        System.out.println("\nПроверка, является ли число числом Фибоначчи:");
        long[] testNumbers = {8, 10, 13, 15, 21};
        for (long num : testNumbers) {
            System.out.println(num + ": " + calculator.isFibonacciNumber(num));
        }
    }
}


