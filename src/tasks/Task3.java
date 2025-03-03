package tasks;

import java.util.HashMap;

// Определить, являются ли две строки анаграммами.
public class Task3 {
    public static void main(String[] args) {
        System.out.println(checkAnagram("java", "vaaj")); //true
        System.out.println(checkAnagram("java", "vabj")); //false
        System.out.println(checkAnagram("java", "javac")); //false

    }

    public static boolean checkAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        HashMap<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            counter.put(s1.charAt(i), counter.getOrDefault(s1.charAt(i), 0) + 1);
            counter.put(s2.charAt(i), counter.getOrDefault(s2.charAt(i), 0) - 1);
        }

        for (int value : counter.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}
