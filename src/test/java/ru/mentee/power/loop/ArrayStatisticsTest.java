package ru.mentee.power.loop;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ArrayStatisticsTest {
    @Test
    void testFindMinMax() {
        int[] testData = {5, 7, 2, 9, 3, 5, 1, 8, 5, 6};
        ArrayStatistics stats = new ArrayStatistics(testData);
        assertThat(stats.findMin()).isEqualTo(1);
        assertThat(stats.findMax()).isEqualTo(9);
    }

    @Test
    void testCalculateSumAndAverage() {
        int[] testData = {5, 7, 2, 9, 3, 5, 1, 8, 5, 6};
        ArrayStatistics stats = new ArrayStatistics(testData);
        assertThat(stats.calculateSum()).isEqualTo(51);
        assertThat(stats.calculateAverage()).isEqualTo(5.1);
    }

    @Test
    void testCalculateMedian() {
        int[] testData1 = {5, 7, 2, 9, 3, 5, 1, 8, 5, 6};
        int[] testData2 = {5, 7, 2, 9, 3, 5, 1, 8, 5};
        ArrayStatistics stats1 = new ArrayStatistics(testData1);
        ArrayStatistics stats2 = new ArrayStatistics(testData2);
        assertThat(stats1.calculateMedian()).isEqualTo(5.0);
        assertThat(stats2.calculateMedian()).isEqualTo(5.0);
    }

    @Test
    void testFindMode() {
        int[] testData = {5, 7, 2, 9, 3, 5, 1, 8, 5, 6};
        ArrayStatistics stats = new ArrayStatistics(testData);
        assertThat(stats.findMode()).isEqualTo(5);
    }

    @Test
    void testCalculateStandardDeviation() {
        int[] testData = {5, 7, 2, 9, 3, 5, 1, 8, 5, 6};
        ArrayStatistics stats = new ArrayStatistics(testData);
        assertThat(Math.round(stats.calculateStandardDeviation() * 100) / 100.0).isEqualTo(2.56);
    }

    @Test
    void testCountGreaterAndLessThan() {
        int[] testData = {5, 7, 2, 9, 3, 5, 1, 8, 5, 6};
        ArrayStatistics stats = new ArrayStatistics(testData);
        assertThat(stats.countGreaterThan(5)).isEqualTo(4);
        assertThat(stats.countLessThan(5)).isEqualTo(3);
    }

    @Test
    void testContains() {
        int[] testData = {5, 7, 2, 9, 3, 5, 1, 8, 5, 6};
        ArrayStatistics stats = new ArrayStatistics(testData);
        assertThat(stats.contains(7)).isTrue();
        assertThat(stats.contains(10)).isFalse();
    }

    @Test
    void testEmptyArray() {
        int[] testData = new int[0];
        ArrayStatistics stats = new ArrayStatistics(testData);
        assertThat(stats.findMin()).isEqualTo(Integer.MAX_VALUE);
        assertThat(stats.findMax()).isEqualTo(Integer.MIN_VALUE);
        assertThat(stats.calculateSum()).isEqualTo(0);
        assertThat(stats.calculateAverage()).isEqualTo(0);
        assertThat(stats.calculateMedian()).isEqualTo(0);
        assertThat(stats.calculateStandardDeviation()).isEqualTo(0);
        assertThat(stats.countLessThan(0)).isEqualTo(0);
        assertThat(stats.countGreaterThan(0)).isEqualTo(0);

    }

    @Test
    void testSingleElementArray() {
        int[] testData = {1};
        ArrayStatistics stats = new ArrayStatistics(testData);
        assertThat(stats.findMin()).isEqualTo(1);
        assertThat(stats.findMax()).isEqualTo(1);
        assertThat(stats.calculateSum()).isEqualTo(1);
        assertThat(stats.calculateAverage()).isEqualTo(1);
        assertThat(stats.calculateMedian()).isEqualTo(1);
        assertThat(stats.calculateStandardDeviation()).isEqualTo(0);
    }

    @Test
    void testArrayWithDuplicates() {
        int[] testData = {1, 1, 1, 1, 1};
        ArrayStatistics stats = new ArrayStatistics(testData);
        assertThat(stats.findMin()).isEqualTo(1);
        assertThat(stats.findMax()).isEqualTo(1);
        assertThat(stats.calculateSum()).isEqualTo(5);
        assertThat(stats.calculateAverage()).isEqualTo(1);
        assertThat(stats.calculateMedian()).isEqualTo(1);
        assertThat(stats.calculateStandardDeviation()).isEqualTo(0.0);
        assertThat(stats.countGreaterThan(0)).isEqualTo(5);
        assertThat(stats.countGreaterThan(1)).isEqualTo(0);
        assertThat(stats.countLessThan(2)).isEqualTo(5);
        assertThat(stats.countLessThan(1)).isEqualTo(0);
        assertThat(stats.contains(1)).isEqualTo(true);
        assertThat(stats.contains(2)).isEqualTo(false);
    }

    @Test
    void testArrayWithNegativeValues() {
        int[] testData = {-1, -2, -3, -4, -5};
        ArrayStatistics stats = new ArrayStatistics(testData);
        assertThat(stats.findMin()).isEqualTo(-5);
        assertThat(stats.findMax()).isEqualTo(-1);
        assertThat(stats.calculateSum()).isEqualTo(-15);
        assertThat(stats.calculateAverage()).isEqualTo(-3);
        assertThat(stats.calculateMedian()).isEqualTo(-3);
        assertThat(Math.round(stats.calculateStandardDeviation() * 100) / 100.0).isEqualTo(1.58);
        assertThat(stats.countGreaterThan(0)).isEqualTo(0);
        assertThat(stats.countLessThan(0)).isEqualTo(5);
        assertThat(stats.contains(-1)).isEqualTo(true);
        assertThat(stats.contains(2)).isEqualTo(false);
    }
}


