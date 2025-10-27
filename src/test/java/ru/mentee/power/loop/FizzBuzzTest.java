package ru.mentee.power.loop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FizzBuzzTest {
    @Test
    public void testFizzBuzzForFirst15Numbers() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] result = fizzBuzz.generateFizzBuzz(15);
        assertThat(result).isNotNull();
        assertThat(result).hasSize(15);
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
        assertThat(result[2]).isEqualTo("Fizz");
        assertThat(result[4]).isEqualTo("Buzz");
        assertThat(result[14]).isEqualTo("FizzBuzz");
    }

    @Test
    public void testFizzBuzzWithZeroInput() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] result = fizzBuzz.generateFizzBuzz(0);
        assertThat(result).isNotNull();
        assertThat(result).isEmpty();
    }

    @Test
    public void testAllFizzValuesAreDivisibleBy3() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] result = fizzBuzz.generateFizzBuzz(15);
        assertThat(result).isNotNull();
        assertThat(result).hasSize(15);
        assertThat(result[2]).isEqualTo("Fizz");
        assertThat(result[5]).isEqualTo("Fizz");
        assertThat(result[8]).isEqualTo("Fizz");
        assertThat(result[11]).isEqualTo("Fizz");
    }

    @Test
    public void testAllBuzzValuesAreDivisibleBy5() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] result = fizzBuzz.generateFizzBuzz(20);
        assertThat(result).isNotNull();
        assertThat(result).hasSize(20);
        assertThat(result[4]).isEqualTo("Buzz");
        assertThat(result[9]).isEqualTo("Buzz");
        assertThat(result[19]).isEqualTo("Buzz");
    }

    @Test
    public void testAllFizzBuzzValuesAreDivisibleBy3And5() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] result = fizzBuzz.generateFizzBuzz(60);
        assertThat(result).isNotNull();
        assertThat(result).hasSize(60);
        assertThat(result[14]).isEqualTo("FizzBuzz");
        assertThat(result[29]).isEqualTo("FizzBuzz");
        assertThat(result[44]).isEqualTo("FizzBuzz");
        assertThat(result[59]).isEqualTo("FizzBuzz");
    }

}

