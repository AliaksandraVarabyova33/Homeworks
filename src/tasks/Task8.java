package tasks;

import java.util.Arrays;
import java.util.HashSet;

//Проверить, является ли set1 подмножеством set2.
public class Task8 {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(2, 3, 4, 5, 1));
        HashSet<Integer> set3 = new HashSet<>(Arrays.asList(2, 3, 4, 5));
        System.out.println(checkSubSet(set1, set2)); //true
        System.out.println(checkSubSet(set1, set3)); //false

    }

    public static boolean checkSubSet(HashSet<Integer> set1, HashSet<Integer> set2) {
        return set2.containsAll(set1);
    }
}
