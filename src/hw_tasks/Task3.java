package hw_tasks;

import java.util.concurrent.atomic.AtomicInteger;

//Синхронизация потоков для предотвращения гонки данных
public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        Counter2 counter = new Counter2();

        Thread myThread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
                System.out.println(Thread.currentThread().getName() + " " + counter.getCount());
            }
        });
        Thread myThread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.decrement();
                System.out.println(Thread.currentThread().getName() + " " + counter.getCount());
            }
        });

        myThread1.start();
        myThread2.start();
    }
}

class Counter2 {

    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public void decrement() {
        count.decrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
