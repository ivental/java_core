package ru.mentee.power.loop;

import java.util.Arrays;

public class ArrayStatistics {
    private final int[] data;

    public ArrayStatistics(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }


    public int findMin() {
        if (data.length == 0) {
            return Integer.MAX_VALUE;
        }
        int min = data[0];
        for (int value : data) {
            if (min > value) {
                min = value;
            }
        }
        return min;
    }


    public int findMax() {
        if (data.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = data[0];
        for (int value : data) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }


    public int calculateSum() {
        if (data.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum;
    }


    public double calculateAverage() {
        if (data.length == 0) {
            return 0;
        }
        double sum;
        double average;
        sum = calculateSum();
        average = sum / data.length;
        return average;
    }


    public double calculateMedian() {
        if (data.length == 0) {
            return 0;
        }
        double median;
        double[] copyArray = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            copyArray[i] = data[i];
        }
        Arrays.sort(copyArray);
        int index = (copyArray.length / 2) - 1;
        int index1 = copyArray.length / 2;
        if (copyArray.length % 2 == 0) {
            median = ((copyArray[index] + copyArray[index1]) / 2.0);
        } else {
            median = copyArray[index1];
        }
        return median;
    }


    public int findMode() {
        if (data.length == 0) {
            return 0;
        }
        int mode = 0;
        double[] dataCopy = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            dataCopy[i] = data[i];
        }
        Arrays.sort(dataCopy);
        int currentNumber = (int) dataCopy[0];
        int maxNumber = (int) dataCopy[0];
        int currentCount = 1;
        int maxCount = 1;

        for (int i = 1; i < dataCopy.length; i++) {
            if (dataCopy[i] == currentNumber) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {

                    maxCount = currentCount;
                    maxNumber = currentNumber;
                }
                currentNumber = (int) dataCopy[i];
                currentCount = 1;
            }
        }
        if (currentCount > maxCount) {
            maxCount = currentCount;
            maxNumber = currentNumber;
        }
        mode = maxNumber;
        return mode;
    }


    public double calculateStandardDeviation() {
        if (data.length == 0 || data.length < 2) {
            return 0;
        }
        double average = calculateAverage();
        double sumOfSquares = 0;
        double variance;
        double standartDeviation;
        double dataAverage;
        double squared;
        for (int i = 0; i < data.length; i++) {
            dataAverage = data[i] - average;
            squared = Math.pow(dataAverage, 2);
            sumOfSquares += squared;
        }
        variance = sumOfSquares / (data.length - 1);
        standartDeviation = Math.sqrt(variance);
        return standartDeviation;
    }

    public int countGreaterThan(int value) {
        if (data.length == 0) {
            return 0;
        }
        int count = 0;
        for (int index : data) {
            if (index > value) {
                count++;
            }
        }
        return count;
    }


    public int countLessThan(int value) {
        if (data.length == 0) {
            return 0;
        }
        int count = 0;
        for (int index : data) {
            if (index < value) {
                count++;
            }
        }
        return count;
    }


    public boolean contains(int value) {
        for (int index : data) {
            if (index == value) {
                return true;
            }
        }
        return false;
    }


    public void printStatisticsReport() {
        System.out.println("===== Статистический отчет =====");
        System.out.println("Размер массива: " + data.length);
        System.out.println("Минимальное значение: " + findMin());
        System.out.println("Максимальное значение: " + findMax());
        System.out.println("Сумма элементов: " + calculateSum());
        System.out.println("Среднее арифметическое: " + calculateAverage());
        System.out.println("Медиана: " + calculateMedian());
        System.out.println("Мода: " + findMode());
        System.out.println("Стандартное отклонение: " + calculateStandardDeviation());
        System.out.println("================================");
    }


    public static void main(String[] args) {
        int[] testData = {5, 7, 2, 9, 3, 5, 1, 8, 5, 6};
        ArrayStatistics stats = new ArrayStatistics(testData);

        System.out.println("Исходный массив: " + Arrays.toString(testData));
        stats.printStatisticsReport();

        System.out.println("Элементов больше 5: " + stats.countGreaterThan(5));
        System.out.println("Элементов меньше 5: " + stats.countLessThan(5));
        System.out.println("Массив содержит 7: " + stats.contains(7));
        System.out.println("Массив содержит 10: " + stats.contains(10));
    }
}



