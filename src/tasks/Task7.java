package tasks;

import java.util.Arrays;
import java.util.HashSet;

//Найти элементы, которые есть в первом множестве, но отсутствуют во втором.
public class Task7 {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(2, 3, 4, 5));
        System.out.println(findDifferentElements(set1, set2)); //[1, 6]
    }

    public static HashSet<Integer> findDifferentElements(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet<Integer> result = new HashSet<>();
        for (Integer element : set1) {
            if (!set2.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
