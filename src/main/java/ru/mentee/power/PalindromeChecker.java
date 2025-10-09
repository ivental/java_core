package ru.mentee.power;
import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindrom(String input) {
        if (input == null) {
            return false; // или true - в зависимости от требований
        }

        String reverseSpelling = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reverseSpelling = reverseSpelling + input.charAt(i);
        }
        return reverseSpelling.equalsIgnoreCase(input);
    }
}


