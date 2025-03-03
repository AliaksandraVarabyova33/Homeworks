package hw_tasks;

import java.util.*;

//Дан список слов. Нужно сгруппировать слова, которые являются анаграммами.
public class Task1 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("listen");
        list.add("java");
        list.add("enlist");
        list.add("avaj");
        list.add("world");
        list.add("silent");
        System.out.println(groupAnagrams(list)); //[[java, avaj], [listen, enlist, silent], [world]]
    }

    public static Collection<ArrayList<String>> groupAnagrams(List<String> list) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String word : list) {
            char[] symbols = word.toCharArray();
            Arrays.sort(symbols);
            String sorted = new String(symbols);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<String>());
            }
            map.get(sorted).add(word);
        }
        return map.values();
    }

}
