package tasks;

import java.util.HashMap;

//Подсчет частоты символов в строке (без регистра)
public class Task10 {
    public static void main(String[] args) {
        countChars("Test string ST1");
    }

    public static void countChars(String s) {
        if (s == null || s.isEmpty()) {
            System.out.println("No symbols are found in the string");;
        }

        String test = s.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character ch : test.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println(map);
    }
}
