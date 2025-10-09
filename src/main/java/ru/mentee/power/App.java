package ru.mentee.power;
import java.util.Scanner;
import static ru.mentee.power.PalindromeChecker.isPalindrom;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите слово или предложение, чтобы узнать, является ли оно палиндромом :  ");
        String userInput = scan.nextLine().trim();
        scan.close();

        if (isPalindrom(userInput)) {
            System.out.println("Введенное выражение является палиндромом.");
        } else {
            System.out.println("Введенное выражение не является палиндромом.");
        }
    }
}
