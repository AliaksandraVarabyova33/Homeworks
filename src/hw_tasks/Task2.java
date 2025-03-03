package hw_tasks;

import java.util.*;

//Дан список чисел, нужно найти первое число, которое повторяется.
public class Task2 {
    public static void main(String[] args) {
        System.out.println(findFirstRepeatingNumber(new ArrayList<>(Arrays.asList(4, 9, 8, 9, 4))));
    }

    public static Optional<Integer> findFirstRepeatingNumber(ArrayList<Integer> list) {
        HashSet<Integer> set = new HashSet<>();

        for (Integer number : list) {
            if (!set.add(number)) {
                return Optional.of(number);
            }
        }
        return Optional.empty();
    }
}
