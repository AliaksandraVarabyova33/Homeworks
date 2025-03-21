package tasks;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Использование CyclicBarrier для синхронизации нескольких потоков.
Есть 4 потока, каждый из которых выполняет часть задачи.
Все потоки должны завершить свои работы, прежде чем главный поток продолжит выполнение.
Нужно синхронизировать потоки так, чтобы они все начинали работать одновременно и завершили выполнение одновременно.
 */
public class Task10 {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4, () -> {
            System.out.println("All threads have reached the barrier");
        });

        Runnable runnable = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " doing smth.");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " has reached the barrier. Waiting to finish...");
                barrier.await();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " finished.");

        };

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            executor.submit(runnable);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("Main thread continue working...");
    }
}
