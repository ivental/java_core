package ru.mentee.power.conditions;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static final String ROCK = "камень";
    public static final String PAPER = "бумага";
    public static final String SCISSORS = "ножницы";
    public static final String WIN = "Победа";
    public static final String LOSE = "Поражение";
    public static final String DRAW = "Ничья";
    public static final String ERROR = "Ошибка";
    private static final List<String> VALID_MOVES = Arrays.asList("камень", "ножницы", "бумага");
    private Scanner scanner = new Scanner(System.in);

    public String determineWinner(String playerMove, String computerMove) {
        if (!validateMove(playerMove) || !validateMove(computerMove)) {
            return ERROR;
        }
        if (playerMove.equals(computerMove)) {
            return DRAW;
        }
        String normalizedGame = playerMove.toLowerCase() + computerMove.toLowerCase();
        switch (normalizedGame) {
            case ROCK + SCISSORS:
                return WIN;
            case ROCK + PAPER:
                return LOSE;
            case SCISSORS + ROCK:
                return LOSE;
            case SCISSORS + PAPER:
                return WIN;
            case PAPER + ROCK:
                return WIN;
            case PAPER + SCISSORS:
                return LOSE;
        }
        return ERROR;
    }

    private boolean validateMove(String move) {
        if (move == null) {
            return false;
        }
        String normalizedMove = move.toLowerCase().trim();
        if (VALID_MOVES.contains(normalizedMove)) {
            return true;
        } else return false;
    }

    public String generateComputerMove() {
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        return VALID_MOVES.get(randomNumber);
    }


    public String playOneGame() {
        System.out.println("Выберите камень, ножницы или бумагу: ");
        String playerMove = scanner.next();
        String computerMove = generateComputerMove();
        System.out.println("Компьютер выбирает: " + computerMove);
        String result = determineWinner(playerMove, computerMove);
        if (result.equals(WIN)) {
            System.out.println("Вы победили!");
        } else if (result.equals(LOSE)) {
            System.out.println("Вы проиграли!");
        } else if (result.equals(DRAW)) {
            System.out.println("Ничья!");
        } else if (result.equals(ERROR)) {
            System.out.println("Ошибка!Неверный ввод!");
        }
        return result;
    }

    public void startGameLoop() {
        System.out.println("--- Давай сыграем в игру? Правила простые, сейчас расскажу! --- ");
        System.out.println("--- Всё элементарно! Тебе нужно выбрать камень, ножницы или бумагу ---");
        System.out.println("--- Камень бьет ножницы, ножницы бьют бумагу, бумага бьет камень ---");
        int win = 0;
        int lose = 0;
        int draw = 0;
        String agreement = "да";
        while (agreement.equalsIgnoreCase("да")) {
            String result = playOneGame();
            if (result.equals(WIN)) {
                win += 1;
            }
            if (result.equals(LOSE)) {
                lose += 1;
            }
            if (result.equals(DRAW)) {
                draw += 1;
            }

            System.out.println("Хотите сыграть ещё? (да/нет)");
            agreement = scanner.next();
            while (!agreement.equalsIgnoreCase("да") && !agreement.equalsIgnoreCase("нет")) {
                System.out.println("Ошибка ввода! Введите `да` или `нет`: ");
                agreement = scanner.next();
            }
        }
        System.out.println("Спасибо за игру! Вот ваша статистика: ");
        System.out.println("Победы: " + win);
        System.out.println("Проигрыши " + lose);
        System.out.println("Ничьи: " + draw);
        System.out.println("Всего сыграно игр: " + (win + draw + lose));
        scanner.close();
    }


    public static void main(String[] args) {
        RockPaperScissors game = new RockPaperScissors();
        game.startGameLoop();
    }
}





