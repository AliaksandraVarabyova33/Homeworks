package hw_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//Дан массив чисел и целевое значение target. Нужно найти все пары чисел, сумма
//которых равна target.
public class Task3 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 1, 2, 2, 0, 4, 5, 10, -1};
        ArrayList<int[]> arr = returnAllPairsWithTargetSum(array, 4);
        for (int[] pair : arr) {
            System.out.println(Arrays.toString(pair));
        }

    }

    public static ArrayList<int[]> returnAllPairsWithTargetSum(int[] array, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<int[]> pairs = new ArrayList<>();

        for (int number : array) {
            int dif = target - number;
            if (map.containsKey(dif)) {
                for (int i = 0; i < map.get(dif); i++) {
                    pairs.add(new int[]{dif, number});
                }
            }
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        return pairs;
    }
}

