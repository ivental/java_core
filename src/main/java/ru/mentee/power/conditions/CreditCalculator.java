package ru.mentee.power.conditions;

import java.util.Arrays;
import java.util.Scanner;


public class CreditCalculator {
    private static final double MIN_LOAN_AMOUNT = 10000;
    private static final double MAX_LOAN_AMOUNT = 10000000;
    private static final int MIN_LOAN_TERM_MONTHS = 1;
    private static final int MAX_LOAN_TERM_MONTHS = 360;
    private static final int MIN_CREDIT_SCORE = 300;
    private static final int MAX_CREDIT_SCORE = 850;
    private static final String[] CREDIT_TYPE = {"Ипотека", "Потребительский", "Автокредит", "ипотека",
            "потребительский", "автокредит"};


    public double calculateMonthlyPayment(double loanAmount, int loanTermMonths, String creditType,
                                          int creditScore) {

        if (loanAmount < MIN_LOAN_AMOUNT || loanAmount > MAX_LOAN_AMOUNT) {
            return -1;
        } else if (loanTermMonths < MIN_LOAN_TERM_MONTHS || loanTermMonths > MAX_LOAN_TERM_MONTHS) {
            return -1;
        } else if (!Arrays.asList(CREDIT_TYPE).contains(creditType)) {
            return -1;
        } else if (creditScore < MIN_CREDIT_SCORE || creditScore > MAX_CREDIT_SCORE) {
            return -1;
        }

        double baseRate = 0;
        switch (creditType) {
            case "Ипотека", "ипотека":
                baseRate = 9.0;
                break;
            case "Потребительский", "потребительский":
                baseRate = 15.0;
                break;
            case "Автокредит", "автокредит":
                baseRate = 12.0;
                break;
        }


        double finalRate = baseRate;
        if (creditScore >= 750 && creditScore <= 850) {
            finalRate = baseRate - 2;
        } else if (creditScore >= 650 && creditScore < 750) {
            finalRate = baseRate - 1;
        } else if (creditScore >= 500 && creditScore < 650) {
            finalRate = baseRate;
        } else if (creditScore >= 300 && creditScore < 500) {
            finalRate = baseRate + 3;
        }

        double monthlyRate = finalRate / 12 / 100;
        double monthlyPayment = loanAmount * (monthlyRate * Math.pow(1 + monthlyRate, loanTermMonths))
                / (Math.pow(1 + monthlyRate, loanTermMonths) - 1);

        return monthlyPayment;
    }

    public static void main(String[] args) {
        CreditCalculator calculator = new CreditCalculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какую сумму желаете получить(от 10,000 до 10,000,000): ");
        double loanAmount = scanner.nextDouble();
        System.out.println("На какой срок желаете получить кредит (от 1 до 360 месяцев): ");
        int loanTermMonths = scanner.nextInt();
        System.out.println("Какой тип кредита Вам нужен(\"Ипотека\", \"Потребительский\", \"Автокредит\"): ");
        String creditType = scanner.next();
        System.out.println("Какой Ваш кредитный рейтинг(от 300 до 850): ");
        int creditScore = scanner.nextInt();
        double monthlyPayment = calculator.calculateMonthlyPayment(loanAmount, loanTermMonths, creditType, creditScore);
        if (monthlyPayment == -1) {
            System.out.println("Введены неверные данные, проверьте параметры и введите ещё раз!");
        } else {
            System.out.println("Ваш ежемесячный платёж по кредиту составит: " + monthlyPayment + " рублей");

        }
        scanner.close();
    }
}



