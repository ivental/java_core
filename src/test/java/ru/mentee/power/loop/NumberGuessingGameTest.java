package ru.mentee.power.loop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class NumberGuessingGameTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testPlayRoundGuessCorrectly() {
        NumberGuessingGame game = new TestableNumberGuessingGame(42);
        String input = "50\n30\n40\n42\nнет\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        game.startGame();


        String output = outputStream.toString();
        assertThat(output).contains("Я загадал число от 1 до 100. Попробуйте угадать!");
        assertThat(output).contains("Загаданное число больше!");
        assertThat(output).contains("Загаданное число меньше!");
        assertThat(output).contains("Поздравляю! Вы угадали число 42");
        assertThat(output).contains("за 4 попыток");

    }

    @Test
    void testStatisticsUpdated() {
        NumberGuessingGame game = new TestableNumberGuessingGame(42);
        String input = "30\n40\n42\nда\n60\n50\n40\n45\n42\nнет\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        game.startGame();
        String output = outputStream.toString();
        assertThat(output).contains("Минимальное количество попыток: 3"); // Минимум (из первого раунда)
        assertThat(output).contains("Максимальное количество попыток: 5"); // Максимум (из второго раунда)
        assertThat(output).contains("Среднее количество попыток: 4.0");   // Среднее: (3+5)/2 = 4.0
        assertThat(output).contains("Сыграно игр: 2");                    // Всего два раунда
    }

    @Test
    void testInvalidInput() {
        // Создаем тестовую версию игры с предопределенным случайным числом 42
        NumberGuessingGame game = new TestableNumberGuessingGame(42);

        // Имитируем различные некорректные варианты ввода:
        // 1. "abc" - не число -> ошибка
        // 2. "-5" - отрицательное число -> ошибка диапазона
        // 3. "200" - слишком большое число -> ошибка диапазона
        // 4. "42" - правильное число -> успех
        // 5. "нет" - отказ от новой игры -> завершение
        String input = "abc\n-5\n200\n42\nнет\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Запускаем игру
        game.startGame();

        // Проверяем сообщения об ошибках для разных случаев
        String output = outputStream.toString();
        assertThat(output).contains("введите целое число"); // Ошибка парсинга строки
        assertThat(output).contains("введите число в диапазоне от 1 до 100"); // Ошибка диапазона
        assertThat(output).contains("Поздравляю! Вы угадали число 42"); // Успешное угадывание
    }

    static class TestableNumberGuessingGame extends NumberGuessingGame {
        private final int fixedNumber;

        TestableNumberGuessingGame(int fixedNumber) {
            this.fixedNumber = fixedNumber;
        }

        @Override
        protected Random createRandom() {
            return new TestableRandom(fixedNumber);
        }
    }

    static class TestableRandom extends Random {
        private final int fixedValue;

        TestableRandom(int fixedValue) {
            this.fixedValue = fixedValue;
        }

        @Override
        public int nextInt(int bound) {
            return fixedValue - 1;
        }
    }
}

