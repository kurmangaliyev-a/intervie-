package org.example.v1__03_08_2024.utils;


import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
public class DividersUtil {

    public static byte[] task2(int valuie) throws IllegalArgumentException {
        StringBuilder result = new StringBuilder();
        if (valuie % 3 == 0) {
            result.append("Fizz");
        }
        if (valuie % 5 == 0) {
            result.append("Buzz");
        }
        if (result.length() == 0) {
            throw new IllegalArgumentException("Value must be divisible by 3 or 5");
        }
        return result.toString().getBytes();
    }

    public static long task2(int n, List<Integer> numbers) {
        Map<Integer, Integer> helloWorld = new HashMap<>();
        long count = 0;
        for (int i = 0; i < n; i++) {
            Integer number = numbers.get(i) % 200;
            Integer orDefault = helloWorld.getOrDefault(number, 0);
            Integer put = helloWorld.put(number, orDefault + 1);
            count += helloWorld.get(number) - 1;
        }
        return count;
    }

    public static int combination(int a, int b) {
        if (a < 0 || a > b) {
            return 0;
        }
        if (a * 2 < b) {
            a = b - a;
        }
        int result = 1;
        for (int i = a + 1; i <= b; i++) {
            result *= i;
        }
        for (int i = 1; i <= b - a; i++) {
            result /= i;
        }
        return result;
    }

    public static int subsetQuantity(int e, int z) {
        int sum = 0;
        for (int i = 1; i <= z + e; i++) {
            for (int j = 1; j <= i && j <= e; j += 2) {
                int combination1 = combination(j, e);
                int combination2 = combination(i - j, z);
                int sum1 = combination1 * combination2;
                sum += sum1;
            }
        }
        return sum;
    }


    private static int convertToArabic(String romanNumber) {
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
        String[] dontUseThis =
                {"IIII", "XXXX", "CCCC", "MMMM"};
        for (String dontUseThi : dontUseThis) {
            if (romanNumber.contains(dontUseThi))
                return -1;
        }
        if (romanNumber.matches(".*V.*V.*")
                || romanNumber.matches(".*L.*L.*")
                || romanNumber.matches(".*D.*D.*")
        )
            return -1;
        int sum = 0;
        int lastValue = -1;
        int nextValue = 100000;
        char[] charArray = romanNumber.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (i == 0) {
                nextValue = 10000;
            } else {
                nextValue = values.get(charArray[i - 1]);
            }
            int c = values.get(charArray[i]);
            if (c >= lastValue) {
                sum += c;
                lastValue = c;
            } else {
                if (
                        ((c == 1 && (lastValue == 5 || lastValue == 10))
                                || (c == 10 && (lastValue == 50 || lastValue == 100))
                                || (c == 100 && (lastValue == 500 || lastValue == 1000)))
                                && c < nextValue
                )
                    sum -= c;
                else return -1;
            }
        }
        return sum;
    }

    public static String exE() {
        Map<String, Integer> romanNumber = new HashMap<>();
        romanNumber.put("VIV", -1);
        romanNumber.put("LL", -1);
        romanNumber.put("DD", -1);
        romanNumber.put("IIII", -1);
        romanNumber.put("XXXX", -1);
        romanNumber.put("CCCC", -1);
        romanNumber.put("MMMM", -1);
        romanNumber.put("CCCL", 350);
        romanNumber.put("II", 2);
        romanNumber.put("MCMLXI", 1961);
        romanNumber.put("MCMLXI", 1961);
        romanNumber.put("MCCMLXI", -1);
        romanNumber.put("MICMLXI", -1);
        romanNumber.put("", 0);
        String errors = "";
        for (Map.Entry<String, Integer> entry : romanNumber.entrySet()) {
            if (entry.getValue() != convertToArabic(entry.getKey())) {
                log.info("{}: {} {}", entry.getKey(), entry.getValue(), convertToArabic(entry.getKey()));
                errors += String.format("{}: {} {}" + entry.getKey() + entry.getValue() + convertToArabic(entry.getKey()));
            }
        }
        return errors;

    }

    public static String exF() {
        Map<String, String> romanNumber = new HashMap<>();
        romanNumber.put("vxOoOoVvx", "vxx");
        romanNumber.put("abBa", "aa");
        romanNumber.put("abBA", "");
        romanNumber.put("abcdDCeEBa", "aa");
        romanNumber.put("AbBa", "");
        romanNumber.put("", "");
        String errors = "";
        for (Map.Entry<String, String> entry : romanNumber.entrySet()) {
            String s = convertToGoodString(entry.getKey());
            if (!entry.getValue().equals(s)) {
                log.info("{}: {} {}", entry.getKey(), entry.getValue(), s);
                errors += String.format("{}: " + entry.getKey() + "{}: " + entry.getValue() + "{}: " + s);
            }
        }
        return errors;

    }

    private static String convertToGoodString(String probablyBadString) {
        char[] charArray = probablyBadString.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length-1; i++) {
            char c =charArray[i];
            if (c + 32 == charArray[i+1] || c-32 == charArray[i+1]){
                charArray = charsRemoveElement(charArray, i);
                int length1 = charArray.length;
                i-=((length-length1)/2+1);
                if(i<-1) i=-1;
                length = length1;
            }
        }
        return new String(charArray);
    }

    private static char[] charsRemoveElement(char[] arr, int index) {
        char[] result = new char[arr.length - 2];
        System.arraycopy(arr, 0, result, 0, index);
        System.arraycopy(arr, index + 2, result, index, arr.length - index - 2);
        return result;
    }
}
