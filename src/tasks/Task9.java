package tasks;

import java.util.*;


//Найти дубликаты в списке и их количество
public class Task9 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 1, 1, 2, 5));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("Test", "Dev", "Test"));
        System.out.println(findDuplicatesInList(list1)); //{1=3, 2=2}
        System.out.println(findDuplicatesInList(list2)); //{Test=2}
    }

    public static <T> HashMap<T, Integer> findDuplicatesInList(List<T> list) {
        HashMap<T, Integer> map = new HashMap<>();
        for (T element : list) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        Iterator<Integer> iterator = map.values().iterator();
        for (Iterator<Integer> it = iterator; it.hasNext(); ) {
            Integer value = it.next();
            if (value == 1) {
                it.remove();
            }
        }
        return map;
    }
}
