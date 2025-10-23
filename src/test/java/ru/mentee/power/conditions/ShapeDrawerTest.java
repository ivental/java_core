package ru.mentee.power.conditions;

import org.junit.jupiter.api.Test;
import ru.mentee.power.loop.ShapeDrawer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ShapeDrawerTest {
    private final ShapeDrawer drawer = new ShapeDrawer();

    @Test
    void testDrawSquare() {
        String expected = "***\n***\n***";
        String result = drawer.drawSquare(3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testDrawEmptySquare() {
        String expected = "***\n* *\n***";
        String result = drawer.drawEmptySquare(3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testDrawTriangle() {
        String expected = "*\n**\n***";
        String result = drawer.drawTriangle(3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testDrawRhombus() {
        String expected = " * \n***\n * ";
        String result = drawer.drawRhombus(3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testWithZeroOrNegativeSize() {
        String expected = "";
        String result = drawer.drawRhombus(0);
        String result1 = drawer.drawSquare(0);
        String result2 = drawer.drawEmptySquare(-2);
        String result3 = drawer.drawTriangle(-1);
        assertThat(result).isEqualTo(expected);
        assertThat(result1).isEqualTo(expected);
        assertThat(result2).isEqualTo(expected);
        assertThat(result3).isEqualTo(expected);
    }

    @Test
    void testWithLargeSize() {
        String expected = "**********\n**********\n**********\n**********\n**********\n**********\n**********\n" +
                "**********\n**********\n**********";
        String result = drawer.drawSquare(10);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testRhombusWithEvenSize() {
        String expected = "  *  \n *** \n*****\n *** \n  *  ";
        String result = drawer.drawRhombus(4);
        assertThat(result).isEqualTo(expected);
    }
}

