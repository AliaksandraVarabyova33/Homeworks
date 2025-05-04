import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        checkPalindromeNumber();
        checkPrimeNumber();
        calculateUntilSingleDigit();
        createInvertedLadder();

    }

    //Task1: Число палиндром
    public static void checkPalindromeNumber() {
        int number = getNumberFromKeyboard();
        String numberStr = Integer.toString(number);
        int left = 0;
        int right = numberStr.length() - 1;

        while (left < right) {
            if (numberStr.charAt(left) != numberStr.charAt(right)) {
                System.out.println("Number is not a palindrome");
                return;
            }
            left++;
            right--;
        }

        System.out.println("Number is a palindrome");
    }

    //Task2: Проверка простого числа
    public static void checkPrimeNumber() {
        int number = getNumberFromKeyboard();
        if (number <= 1) {
            System.out.println("Number in not prime number");
            return;
        }
        for (int i = 2; i < Math.sqrt(number); i++) {
            if ((number % i == 0)) {
                System.out.println("Number in not prime number");
                return;
            }
        }
        System.out.println("Number is a prime number");
    }

    //Task3: Вычисление суммы цифр числа до единичного разряда
    public static void calculateUntilSingleDigit() {
        int number = getNumberFromKeyboard();
        while (number >= 10) {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            number = sum;
        }
        System.out.println(number);
    }

    //Task4: Перевёрнутая лесенка
    public static void createInvertedLadder() {
        int height = getNumberFromKeyboard();
        for (int i = height; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    //Additional reusable method to get data from console
    public static int getNumberFromKeyboard() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = sc.nextInt();
        sc.close();
        return number;
    }
}
