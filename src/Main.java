import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        checkFileNotFoundException();
        checkTwoExceptions(1, 0);
        checkUserInput();
        checkTwoExceptions(5, 0);
        checkStackOverflowError(2);
        System.out.println("Test String");
        checkUserAge();
        System.out.println(divideTwoNumbers());
        checkUserIsNotTooYoung();
        checkStringIsNotEmpty();


    }

    //Исключение при работе с файлами (FileNotFoundException)
    public static void checkFileNotFoundException() {
        try {
            FileReader fileReader = new FileReader("test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Test string after exception");
    }

    //: Обработать исключения на разных уровнях (деление на ноль и выход за границы массива).
    public static void checkTwoExceptions(int index, int number) {
        int[] array = {1, 2, 3};
        try {
            System.out.println(array[index] / number);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("Test string after exception");
    }

    /*Напишите программу, которая запрашивает у пользователя команду (ADD,
    REMOVE, EXIT). Обработайте исключения, если команда нераспознаваема.*/
    public static void checkUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ADD, REMOVE or EXIT");
        boolean isCorrectInput = false;
        String command = "n/a";

        while (!isCorrectInput) {
            switch (scanner.nextLine()) {
                case ("ADD"):
                    isCorrectInput = true;
                    command = "ADD";
                    break;
                case ("REMOVE"):
                    isCorrectInput = true;
                    command = "REMOVE";
                    break;
                case ("EXIT"):
                    isCorrectInput = true;
                    command = "EXIT";
                    break;
                default:
                    try {
                        throw new InvalidCommandException("Your input is not correct. Try again: enter ADD, REMOVE or EXIT");
                    } catch (InvalidCommandException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }

        System.out.println("You entered the following command: " + command);
    }

    //Написать рекурсивную функцию, которая вызывает саму себя, пока не достигнет предела глубины
    public static void checkStackOverflowError(int a) {
        a = a + 1;
        System.out.println(a);
        try {
            checkStackOverflowError(a);
        } catch (StackOverflowError e) {
        }
        return;
    }

    //Запросить у пользователя возраст и проверить, является ли он числом от 0 до 120
    public static void checkUserAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age (0-120)");
        int age = -1;

        while (true) {
            try {
                if (!scanner.hasNextInt()) {
                    throw new InvalidAgeException("Incorrect input. Please enter a number.");
                }
                age = scanner.nextInt();
                if (age < 0 || age > 120) {
                    throw new InvalidAgeException("Incorrect age. Try again (0-120).");
                }
                break;
            } catch (InvalidAgeException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        System.out.println("Your age is " + age);
    }

    // Задача 1:Деление с обработкой исключения: ArithmeticException, InputMismatchException
    public static Integer divideTwoNumbers() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two integers");
        int a;
        int b;
        Integer result = null;

        while (true) {
            try {
                a = sc.nextInt();
                b = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input. Start again - Enter two integers");
                sc.nextLine();
                continue;
            }
            break;
        }
        try {
            result = a / b;
        } catch (ArithmeticException e) {
            System.out.println("You can't divide by zero");
        }
        return result;

    }

    //Задача 2: Проверка возраста (кастомное исключение): Если возраст < 18 - выбрасываем TooYoungException
    public static void checkUserIsNotTooYoung() {
        Scanner scanner = new Scanner(System.in);
        int age;
        System.out.println("Enter your age");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Enter your age");
        }

        age = scanner.nextInt();
        if (age < 18) {
            try {
                throw new TooYoungException("You are too young. Access declined");
            } catch (TooYoungException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Access granted. Your age is " + age);
        }
    }

    //Задача: Запросить у пользователя строку и проверить, что она не пустая: IllegalArgumentException, если строка пустая.
    public static void checkStringIsNotEmpty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text");
        String text = scanner.nextLine();
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Text can't be empty");
        }
    }
}

