package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//Найти общие элементы двух List<Int>
public class Task6 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 2));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 6, 7, 6));
        System.out.println(findCommonElements(list1, list2)); //[1, 2, 3, 6]
    }

    public static HashSet<Integer> findCommonElements(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        HashSet<Integer> list1UniqueElements = new HashSet<>(list1);
        HashSet<Integer> commonElements = new HashSet<>();

        for (Integer element : list2) {
            if (list1UniqueElements.contains(element)) {
                commonElements.add(element);
            }
        }
        return commonElements;

    }
}
