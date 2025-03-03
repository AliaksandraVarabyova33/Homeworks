package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//Проверить, содержит ли List<Int> только уникальные элементы.
public class Task5 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 4));
        System.out.println(checkIfListContainsOnlyUniqueElements(list1)); //true
        System.out.println(checkIfListContainsOnlyUniqueElements(list2)); //false
    }

    public static boolean checkIfListContainsOnlyUniqueElements(ArrayList<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer element : list) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        for (Integer value : map.values()) {
            if (value != 1) {
                return false;
            }
        }
        return true;
    }
}
