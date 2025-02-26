import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] test = new int[]{5, 5, 5, 2, 8, 2, 2, 0, 5, 5, 2, 1, 1, 3, 1, 1, 7, 1, 7};
        //sortArrayWithNegativeValuesSavingOrder(test);
        sortArrayByNumberOfRepeatingElements(test);
    }

    //Task1: Сортировка массива с отрицательными числами *
    public static void sortArrayWithNegativeValuesSavingOrder(int[] array) {
        boolean isSorted = false;
        int temp;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] >= 0 && array[i + 1] < 0) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //Task2: Частотная сортировка
    public static void sortArrayByNumberOfRepeatingElements(int[] array) {
        //Шаг1: создаем мапу, проходимся по массиву и складываем туда элемент как ключ, кол-во вхождений как значение
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int count = 1;
            if (!map.containsKey(array[i])) {
                map.put(array[i], count);
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        count++;
                        map.put(array[i], count);
                    }
                }
            }
        }
        System.out.println("Map: " + map);

        //Шаг2: создаем временный массив и переливаем туда все значения из мапы
        int[] tempArray = new int[map.size() * 2];
        int arrIn = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            tempArray[arrIn] = entry.getKey();
            tempArray[arrIn + 1] = entry.getValue();
            arrIn += 2;
        }
        System.out.println("Temp array without sorting: " + Arrays.toString(tempArray));

        /*Шаг3: сортируем этот временный массив пузырьком, переставляя пары
        Свапаем пары, если у одной из пар кол-во вхождений больше, чем у второй.
        Либо если кол-во вхождений равное, то тогда сравниваем сами значения, чтобы они шли в возр. порядке*/

        boolean isSorted = false;
        int temp;
        int temp2;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < tempArray.length - 2; i += 2) {
                if (tempArray[i] < tempArray[i + 2] || (tempArray[i] == tempArray[i + 2] && tempArray[i - 1] > tempArray[i + 1])) {
                    temp = tempArray[i];
                    temp2 = tempArray[i - 1];
                    tempArray[i] = tempArray[i + 2];
                    tempArray[i - 1] = tempArray[i + 1];
                    tempArray[i + 2] = temp;
                    tempArray[i + 1] = temp2;
                    isSorted = false;
                }
            }
        }
        System.out.println("Temp array with sorting: " + Arrays.toString(tempArray));

        /*Шаг4: Сортируем оригинальный массив (по сути перезаписываем): мы знаем, что во временном массиве первый элемент это значение,
        второй кол-во повторений, и такие пары до конца массива
        Идем по временному массиву и записываем значение (tempArray[i-1]) n-ое кол-во раз (tempArray[i])*/
        int arrIn2 = 0;
        for (int i = 1; i < tempArray.length; i += 2) {
            for (int n = 0; n < tempArray[i]; n++) {
                array[arrIn2] = tempArray[i - 1];
                arrIn2++;
            }
        }
        System.out.println("Final result: " + Arrays.toString(array));
    }
}
