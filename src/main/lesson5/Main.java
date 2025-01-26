public class Main {

    public static void main(String[] args) {
        int[] testArray = new int[]{12, 1, 2, 3, 2, 1, 18};
        findMinAndMaxArrayElements(testArray);
        countEvenAndOddNumbers(testArray);
        reverseArray(testArray);
        checkIfArrayIsPalindrome(testArray);
    }

    //Task1: Поиск максимального и минимального элемента массива
    public static void findMinAndMaxArrayElements(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.printf("Min = %d. Max = %d%n", min, max);
    }

    //Task2: Подсчет четных и нечетных чисел в массиве
    public static void countEvenAndOddNumbers(int[] array) {
        int countOdd = 0;
        int countEven = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }
        System.out.printf("Odd numbers: %d. Even numbers: %d%n", countOdd, countEven);
    }

    //Task3: Реверс массива
    public static void reverseArray(int[] array) {
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    //Task 4: Проверка на палиндром
    public static void checkIfArrayIsPalindrome(int[] array) {
        for (int i = 0, j = array.length - 1; i < array.length / 2; i++, j--) {
            if (array[i] != array[j]) {
                System.out.println("Array is not palindrome");
                return;
            }
        }
        System.out.println("Array is palindrome");
    }
}
