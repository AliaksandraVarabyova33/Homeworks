package tasks;

import java.util.concurrent.CyclicBarrier;

/*Реализуй программу, где 3 потока выполняют работу и ждут друг друга на CyclicBarrier.
 Когда все потоки достигли барьера, они продолжают выполнение.
 */
public class Task6 {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All threads have reached the barrier");
        });

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " doing smth.");
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " has reached the barrier. Waiting...");
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " continue doing smth.");

        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
