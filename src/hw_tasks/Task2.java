package hw_tasks;

import java.util.concurrent.atomic.AtomicInteger;

//Применение атомарных типов для безопасного увеличения счетчика
public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        CounterWithAtomic counter = new CounterWithAtomic();

        Thread myThread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
                System.out.println(Thread.currentThread().getName() + " " + counter.getCount());
            }
        });
        Thread myThread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
                System.out.println(Thread.currentThread().getName() + " " + counter.getCount());
            }
        });

        myThread1.start();
        myThread2.start();
    }
}

class CounterWithAtomic {

    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
