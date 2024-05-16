package org.example.util;

public class ParserUtils {

    public static boolean isInRange(Integer low, Integer high, String number) {
        return Integer.parseInt(number) <= high && Integer.parseInt(number) >= low;
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

}
