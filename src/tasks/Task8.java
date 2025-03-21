package tasks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Используй ThreadPoolExecutor для обработки 10 задач, каждая из которых выполняется 1 секунду.
public class Task8 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " task " + finalI + " is in progress");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
    }
}
