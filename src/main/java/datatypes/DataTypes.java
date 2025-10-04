package datatypes;
import java.util.Arrays;

public class DataTypes {
    public static void main(String[] args) {

        byte temperature = 30;
        short population = 30000;
        int users = 100000;
        long worldPopulation = 7800000000L;
        float price = 99.99f;
        double pi = 3.14159265359;
        char grade = 'A';
        boolean isActive = true;
        String firstName = "Илья";
        String secondName = "Юкин";
        String[] names = {"АРТЁМ", "АЛЬБЕРТ", "АНУФРИЙ"};

        short fromByte = temperature;
        long fromInt = users;
        double sum = pi + temperature;
        float mult = price * worldPopulation;
        int approximatePi = (int)pi;
        String fullName = firstName + " " + secondName;
        String numberAsString = "50";
        int numberFromString = Integer.parseInt(numberAsString);
        int stringAsNumber = 50;
        String stringFromInt = String.valueOf(stringAsNumber);
        String stringFromChar = String.valueOf(grade);
        String massiveString = Arrays.toString(names);

        System.out.println("Преобразование из byte в short: " + fromByte);
        System.out.println("Преобразование из int в long: " + fromInt);
        System.out.println("Сложение double и byte: " + sum);
        System.out.println("Умножение float и long: " + mult);
        System.out.println("Явное приведение double в int: " + approximatePi);
        System.out.println("Конкатенация строк: " + fullName);
        System.out.println("Преобразование строки в числовое значение: " + numberFromString);
        System.out.println("Преобразование числового значения в строку: " + stringFromInt);
        System.out.println("Преобразование символа в строку: " + stringFromChar);
        System.out.println("Массив в строку: " + massiveString);
    }
}


