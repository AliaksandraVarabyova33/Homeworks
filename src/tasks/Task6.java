package tasks;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

//Реализуйте пример, в котором используется метод compareAndSet из AtomicInteger для условного изменения значения.
public class Task6 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = createRandomAtomicInteger();
        AtomicBoolean isChanged = new AtomicBoolean(false);
        System.out.println("AtomicInteger: " + atomicInteger);

        Thread myThread1 = new Thread(() -> {
            while (!isChanged.get()) {
                if (atomicInteger.compareAndSet(createRandomInteger(), createRandomInteger())) {
                    isChanged.set(true);
                    System.out.println(Thread.currentThread().getName() + " sets atomicInteger");
                } else
                    System.out.println(Thread.currentThread().getName() + " AtomicInteger does not match expected value");
            }
        });

        Thread myThread2 = new Thread(() -> {
            while (!isChanged.get()) {
                if (atomicInteger.compareAndSet(createRandomInteger(), createRandomInteger())) {
                    isChanged.set(true);
                    System.out.println(Thread.currentThread().getName() + " sets atomicInteger");
                } else
                    System.out.println(Thread.currentThread().getName() + " AtomicInteger does not match expected value");
            }

        });

        myThread1.setName("Thread1");
        myThread1.start();
        myThread2.setName("Thread2");
        myThread2.start();
    }

    public static AtomicInteger createRandomAtomicInteger() {
        Random random = new Random();
        return new AtomicInteger(random.nextInt(1, 10));
    }

    public static int createRandomInteger() {
        Random random = new Random();
        return random.nextInt(1, 10);
    }
}
