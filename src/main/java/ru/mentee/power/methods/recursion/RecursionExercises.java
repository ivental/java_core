package ru.mentee.power.methods.recursion;

public class RecursionExercises {

    public static long factorial(int n) {
        if (n < 0) return -1;
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static long fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException();
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long fibonacciOptimized(int n) {
        if (n < 0) return -1;
        if (n <= 1) return n;
        int firstFibonacci = 0;
        int secontFibonacci = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = firstFibonacci + secontFibonacci;
            firstFibonacci = secontFibonacci;
            secontFibonacci = result;
        }
        return result;
    }

    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        String cleaned = str.toLowerCase().replaceAll("[^a-zа-я]", "");
        if (cleaned.length() <= 1 || cleaned.isEmpty()) {
            return true;
        }
        if (cleaned.charAt(0) != cleaned.charAt(cleaned.length() - 1)) {
            return false;
        }
        return isPalindrome(cleaned.substring(1, cleaned.length() - 1));
    }

    public static int sumOfDigits(int n) {
        if (n == 0) return 0;
        if (n < 0) {
            int negative = n;
            negative = Math.abs(negative);
            return negative;
        }
        int sum = n;
        sum = n % 10 + sumOfDigits(n / 10);
        return sum;
    }

    public static double power(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        if (exponent < 0) {
            return 1 / power(base, -exponent);
        }
        return base * power(base, exponent - 1);
    }


    public static int gcd(int a, int b) {
        if (b == 0) return a;
        if (a == 0) return b;
        return gcd(b, a % b);
    }

    public static void reverseArray(int[] array, int start, int end) {
        if (start >= end) {
        } else {
            int result = array[start];
            array[start] = array[end];
            array[end] = result;
            reverseArray(array, start + 1, end - 1);
        }
    }
}
