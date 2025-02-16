package javahw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        //array tasks
        findTargetSum(new int[]{6, 8, 1, 2, 5, 9, 4, 10, 0, 14}, 14);
        moveZeroesToTheEnd(new int[]{0, 8, 0, 0, 5, 0});
        System.out.println("Do arrays match? - " + checkArrays(new int[]{0, 8, 0, 0, 5, 0}, new int[]{0, 5, 0, 8, 0, 8}));
        findMaxSubArraySum(new int[]{6, 8, 5, 9, 10, 1}, 3);
        findMaxSubArrayProduct(new int[]{-5, 10, -1, 0, 10, 4, 2});


        //Task2 (enum isWinter() method) check
        for (Month month : Month.values()) {
            System.out.println("Is " + month + " winter month? - " + month.isWinter());
        }

        //Task 1/3 check
        Author a1 = new Author("Sasha1", 1993);
        Author a2 = new Author("Sasha", 1992);
        Book b1 = new Book("test", a1, 2001);
        Book b2 = new Book("test", a2, 2005);
        System.out.println(b1.equals(b2));

        //Task4 check
        Role businessUser = Role.USER;
        Role developer = Role.ADMIN;
        Role tester = Role.ADMIN;
        System.out.println(businessUser.customEquals(developer));
        System.out.println(tester.customEquals(developer));


    }

    //Task1: Найти все пары с заданной суммой
    public static void findTargetSum(int[] array, int targetSum) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
                    System.out.println(array[i] + ", " + array[j]);
                    count++;
                }
            }
        }
        System.out.println("Number of pairs found = " + count);
    }

    //Task2: Перестановка нулей в конец
    public static void moveZeroesToTheEnd(int[] array) {
        int insertIndex = 0;
        for (int element : array) {
            if (element != 0) {
                array[insertIndex] = element;
                insertIndex++;
            }
        }

        while (insertIndex < array.length) {
            array[insertIndex] = 0;
            insertIndex++;
        }
        System.out.println(Arrays.toString(array));
    }

    //Task3: Проверка на перестановку (анаграмма массива)
    public static boolean checkArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int element : array1) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        for (int element : array2) {
            map.put(element, map.getOrDefault(element, 0) - 1);
        }
        for (Map.Entry<Integer, Integer> mapEl : map.entrySet()) {
            if (mapEl.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    //Task4: Максимальная сумма подмассива фиксированной длины
    public static void findMaxSubArraySum(int[] array, int k) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i <= array.length - k; i++) {
            if (i == 0) {
                for (int j = i, x = k; x > 0; j++, x--) {
                    sum += array[j];
                }
            } else {
                sum += array[i + k - 1] - array[i - 1];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        System.out.println("Max sum is: " + maxSum);
    }

    //Task 5: Максимальный произведённый подмассив
    public static void findMaxSubArrayProduct(int[] array) {
        int maxProduct = Integer.MIN_VALUE;
        int product;

        for (int i = 0; i < array.length; i++) {
            product = 1;
            for (int j = i; j < array.length; j++) {
                product *= array[j];
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }

        System.out.println("Max product = " + maxProduct);
    }
}
