package tasks;

/*Объединение двух Map с суммированием значений
  Объединить Map<String, Int>, суммируя повторяющиеся ключи*/

import java.util.HashMap;
import java.util.Map;

public class Task4 {
    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("aaa", 5);
        map1.put("bbb", 10);
        map1.put("ccc", 2);
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("ddd", 4);
        map2.put("aaa", 10);
        map2.put("ccc", 2);
        System.out.println(uniteMapsWithSums(map2, map1)); //{aaa=15, ccc=4, bbb=10, ddd=4}

    }

    public static HashMap<String, Integer> uniteMapsWithSums
            (HashMap<String, Integer> map1, HashMap<String, Integer> map2) {

        HashMap<String, Integer> finalMap = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {

            String key = entry.getKey();

            if (finalMap.containsKey(key)) {
                finalMap.put(key, finalMap.get(key) + entry.getValue());
            } else {
                finalMap.put(key, entry.getValue());
            }
        }
        return finalMap;
    }
}
