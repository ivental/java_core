package ru.mentee.power.methods.overloading;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DataFormatter {

    public static String format(int value) {
        if (value == 0) {
            return "0";
        }
        int numberToFormat = value;
        boolean isNegative = false;
        if (value < 0) {
            isNegative = true;
            numberToFormat = Math.abs(value);

        }
        StringBuilder valueStr = new StringBuilder();
        valueStr.append(numberToFormat);
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = valueStr.length() - 1; i >= 0; i--) {
            result.insert(0, valueStr.charAt(i));
            count++;
            if (count % 3 == 0) {
                result.insert(0, " ");
            }
        }

        if (isNegative) {
            result.insert(0, "-");
        }
        String resultValue = result.toString();
        return resultValue;
    }


    public static String format(int value, String prefix, String suffix) {
        if (prefix == null && suffix == null) {
            return "";
        }
        String formattedValue = format(value);
        String result = prefix + formattedValue + " " + suffix;
        return result;
    }


    public static String format(double value) {
        if (Double.isInfinite(value)) {
            return "";
        }
        if (Double.isNaN(value)) {
            return "";
        }
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setGroupingSeparator(' ');
        decimalFormatSymbols.setDecimalSeparator(',');
        DecimalFormat dF = new DecimalFormat("#,##0.00", decimalFormatSymbols);
        String result = dF.format(value);
        return result;
    }

    public static String format(double value, int decimalPlaces) {
        if (Double.isInfinite(value)) {
            return "";
        }
        if (Double.isNaN(value)) {
            return "";
        }
        if (decimalPlaces < 0) {
            return "";
        }
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setGroupingSeparator(' ');
        decimalFormatSymbols.setDecimalSeparator(',');
        DecimalFormat dF;
        if (decimalPlaces > 0) {
            dF = new DecimalFormat("#,##0." + "0".repeat(decimalPlaces), decimalFormatSymbols);
        } else {
            dF = new DecimalFormat("#,##0", decimalFormatSymbols);
        }
        String result = dF.format(value);
        return result;
    }

    public static String format(Date date) {
        if(date == null){
            return "";
        }
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String result = df.format(date);
        return result;
    }

    public static String format(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        if (pattern == null || pattern.isEmpty()) {
            return "";
        }
        SimpleDateFormat df = new SimpleDateFormat(pattern, Locale.ENGLISH);
        String result = df.format(date);
        return result;
    }

    public static String format(List<String> items) {
        if (items == null || items.isEmpty()){
            return "";
        }
        String result = String.join(", ",items);
        return result;
    }

    /**
     * Форматирует список строк, объединяя их через указанный разделитель
     *
     * @param items     Список строковых элементов
     * @param delimiter Разделитель
     * @return Объединенная строка
     */
    public static String format(List<String> items, String delimiter) {
        if (items == null || items.isEmpty()){
            return "";
        }
        if (delimiter == null){
            return "";
        }
        String result = String.join(delimiter,items);
        return result;

    }
}

