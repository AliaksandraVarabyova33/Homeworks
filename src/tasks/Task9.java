package tasks;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//Реализуй очередь с BlockingQueue, куда один поток добавляет элементы, а другой извлекает их с интервалом в 1 секунду.
public class Task9 {

    public static void main(String[] args) {

        BlockingQueue<Integer> elements = new LinkedBlockingQueue<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    elements.put(i);
                    System.out.println(Thread.currentThread().getName() + " adding element " + i + " queue: " + elements);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                while (thread1.isAlive() || !elements.isEmpty()) {
                    Integer element = elements.poll();
                    System.out.println(Thread.currentThread().getName() + " removing element " + element + " queue: " + elements);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
