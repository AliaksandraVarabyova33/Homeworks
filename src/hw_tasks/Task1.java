package hw_tasks;

import tasks.Task9;

import java.util.Random;

//Задача 1: Синхронизация доступа к счетчику с помощью внешнего объекта
public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

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

class Counter {
    final Object mutex = new Object();
    private int count;

    public void increment() {
        synchronized (mutex) {
            count++;
        }
    }

    public void decrement() {
        synchronized (mutex) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}

