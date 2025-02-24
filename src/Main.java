import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Задача 3: Дан ArrayList<Integer>. Используйте Iterator, чтобы удалить все числа, кратные 3.
        removeFromListWithIterator();

        /* Задача 4: Очередь задач (ArrayDeque): Реализуйте систему обработки задач с приоритетом на ArrayDeque.
           Для решения добавлен класс TasksBoard */
        TasksBoard tasksBoard = new TasksBoard();
        tasksBoard.addTask("New feature development");
        tasksBoard.addTask("Unit tests creation");
        tasksBoard.addTask("Tech debt");
        tasksBoard.addUrgentTask("Hotfix");
        tasksBoard.showTasks();
        tasksBoard.processTask();
        tasksBoard.showTasks();

        //Задача 5: Проверка сбалансированности скобок (Stack)
        System.out.println(checkBrackets("test(int[]array){}"));
        System.out.println(checkBrackets("}{()"));
        System.out.println(checkBrackets("([]]"));
        System.out.println(checkBrackets("()(()))"));

        //Задача 6: Сортировка ArrayList без Collections.sort()
        ArrayList<Integer> list = createArrayList();
        System.out.println(list);
        System.out.println(bubbleSort(list));

        //Задача 7: Обратный порядок слов (Stack)
        System.out.println(reverseWords());

        //HW Task1
        removePeopleFromTheCircle(6);

        //HW task2
        uniteTwoLinkedLists();

    }

    //Задача 3: Дан ArrayList<Integer>. Используйте Iterator, чтобы удалить все числа, кратные 3.
    public static void removeFromListWithIterator() {
        ArrayList<Integer> numbers = createArrayList();
        System.out.println(numbers);

        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() % 3 == 0) {
                iterator.remove();
            }
        }
        System.out.println(numbers);
    }

    public static ArrayList<Integer> createArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            list.add(random.nextInt(0, 20));
        }
        return list;
    }

    //Задача 5: Проверка сбалансированности скобок (Stack)
    public static boolean checkBrackets(String testString) {
        Stack<Character> stack = new Stack<>();

        char[] chars = testString.toCharArray();
        for (char ch : chars) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if ((ch == ')' || ch == ']' || ch == '}')) {
                if (stack.empty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    //Задача 6: Сортировка ArrayList без Collections.sort()

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> list) {
        int temp;
        boolean isSorted = false;
        int count = 0;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < list.size() - 1 - count; i++) {
                int current = list.get(i);
                int next = list.get(i + 1);

                if (current > next) {
                    temp = next;
                    list.set(i + 1, current);
                    list.set(i, temp);
                    isSorted = false;
                }
            }
            count++;
        }
        return list;
    }

    //Задача 7: Обратный порядок слов (Stack)
    public static String reverseWords() {
        String test = "Hello world Java";
        Stack<String> stack = new Stack<>();
        String[] words = test.split(" ");

        for (String word : words) {
            stack.push(word);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /*Задача 1: Последний оставшийся элемент (LinkedList)
    В круге из n человек каждый 2-й выбывает, пока не останется один. Используйте LinkedList*/
    public static void removePeopleFromTheCircle(int n) {
        LinkedList<Integer> humans = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            humans.add(i);
        }
        System.out.println(humans);

        int index = 0;
        while (humans.size() > 1) {
            index = (index + 1) % humans.size();
            humans.remove(index);
            System.out.println(humans);
        }
    }

    //Задача 2: Слияние двух отсортированных LinkedList в один (без Set, Map)
    public static void uniteTwoLinkedLists() {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(5);
        list1.add(6);
        list1.add(7);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(6);
        list2.add(9);

        int ind1 = 0;
        int ind2 = 0;
        while (ind1 < list1.size() && ind2 < list2.size()) {
            if (list1.get(ind1) <= list2.get(ind2)) {
                ind1++;
            } else {
                list1.add(ind1, list2.get(ind2));
                ind1++;
                ind2++;
            }
        }

        // Добавляем оставшиеся элементы из list2
        while (ind2 < list2.size()) {
            list1.add(list2.get(ind2));
            ind2++;
        }
        System.out.println(list1);
    }
}


