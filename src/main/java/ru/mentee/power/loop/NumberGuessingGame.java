package ru.mentee.power.loop;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private final Random random;
    private final Scanner scanner = new Scanner(System.in);

    private int gamesPlayed = 0;
    private int minAttempts = Integer.MAX_VALUE;
    private int maxAttempts = 0;
    private int totalAttempts = 0;
    public NumberGuessingGame() {
        this.random = createRandom();
    }


    protected Random createRandom() {
        return new Random();
    }


    public void startGame() {
        System.out.println("Давай сыграем в игру 'Угадай число!'");
        System.out.println("Правила простые: я загадываю число от 1 до 100.");
        System.out.println("Твоя задача угадать его, я буду давать подсказки меньше или больше твое " +
                "число чем загаданное");
        System.out.println("Начинаем!");
        int attempts = 0;
        do {
            attempts = playRound();
            updateStatistics(attempts);
        } while (askPlayAgain());
        showStatistics();
    }


    public int playRound() {
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        boolean guessed = false;

        System.out.println("Я загадал число от 1 до 100. Попробуйте угадать!");

        do {
            System.out.println("Введите Вашу догадку (или нажмите 'q' для выхода): ");

            if (!scanner.hasNext()) {
            break;
        }
            String input = scanner.next();
            if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) {
                System.out.println("Игра прервана. Загаданное число было: " + secretNumber);
                return attempts;
            }
            int guess;
            try {
                guess = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число!");
                continue;
            }
            if (guess < 1 || guess > 100) {
                System.out.println("Введите число в диапазоне от 1 до 100");
                continue;
            }
            attempts++;
            if (guess == secretNumber) {
                System.out.println("Поздравляю! Вы угадали число " + secretNumber + " за "
                        + attempts + " попыток");
                guessed = true;
            } else if (guess < secretNumber) {
                System.out.println("Загаданное число больше!");
            } else if (guess > secretNumber) {
                System.out.println("Загаданное число меньше!");
            }
        } while (!guessed);

        return attempts;
    }


    private void updateStatistics(int attempts) {
        if (minAttempts > attempts) {
            minAttempts = attempts;
        }
        if (maxAttempts < attempts) {
            maxAttempts = attempts;
        }
        gamesPlayed = gamesPlayed + 1;
        totalAttempts = totalAttempts + attempts;
    }


    public void showStatistics() {
        System.out.println("Игр сыграно: " + gamesPlayed);
        System.out.println("Минимальное кол-во попыток " + minAttempts);
        System.out.println("Максимальное кол-во попыток " + maxAttempts);
        double averageAttempt = (double) totalAttempts / gamesPlayed;

        if (gamesPlayed == 0) {
            System.out.println("Не сыграно ни одной игры!");
        } else {
            System.out.println("Среднее кол-во попыток: " + averageAttempt);
        }
    }


    private boolean askPlayAgain() {
        System.out.print("Хотите сыграть еще раз? (да/нет): ");
        if (!scanner.hasNext()) {
            return false;
        }
        String answer = scanner.next().toLowerCase();
        return answer.equals("да") || answer.equals("yes") || answer.equals("y");
    }


    public void close() {
        scanner.close();
    }

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();

        try {
            game.startGame();
        } finally {
            game.close();
        }
    }
}

