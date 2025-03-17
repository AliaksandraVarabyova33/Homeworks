package tasks;

//Создайте 5 потоков, каждый из которых будет выводить число от 1 до 100.

import java.util.ArrayList;
import java.util.List;

public class Task7 {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            threads.add(new Thread(Task7::printNumber));
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void printNumber() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
