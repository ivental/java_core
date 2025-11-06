package ru.mentee.power.methods;

import java.util.Arrays;

public class StringUtils {

    public static int countChars(String str, char target) {
        if (str == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }

    public static String truncate(String str, int maxLength) {
        if (str == null || maxLength <= 0) {
            return "";
        }
        if (str.length() <= maxLength) {
            return str;
        } else {
            if (maxLength > 3) {
                return str.substring(0, maxLength) + "...";
            }
            if (maxLength <= 3) {
                return str.substring(0, maxLength);
            }
        }
        return str;
    }

    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String invertedStr = "";
        String cleanedStr = str.toLowerCase().replaceAll("[^a-z]", "");
        for (int i = cleanedStr.length() - 1; i >= 0; i--) {
            invertedStr = invertedStr + cleanedStr.charAt(i);
        }
        return invertedStr.equals(cleanedStr);
    }

    /**
     * Заменяет все последовательности пробельных символов одним пробелом.
     * Удаляет пробелы в начале и конце строки.
     *
     * @param str Исходная строка
     * @return Нормализованная строка
     */
    public static String normalizeSpaces(String str) {
        if (str == null) {
            return "";
        }
        String trimmedStr = str.trim();
        String normalizedStr = trimmedStr.replaceAll("\\s+", " ");
        return normalizedStr;
    }

    public static String join(String[] strings, String delimiter) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean isFirst = true;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != null) {
                if (isFirst) {
                    stringBuilder.append(strings[i]);
                } else {
                    stringBuilder.append(delimiter).append(strings[i]);
                }
                isFirst = false;
            }
        }
        return stringBuilder.toString();
    }
}
