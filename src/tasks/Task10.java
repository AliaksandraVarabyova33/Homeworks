package tasks;

import java.util.concurrent.atomic.AtomicBoolean;

//Используйте AtomicBoolean для атомарного изменения состояния (например, для флага завершения работы потока).
public class Task10 {

    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean isRunning = new AtomicBoolean(false);

        Thread myThread = new Thread(() -> {
            while (!isRunning.get()) {
                System.out.println("myThread is running");
            }
            System.out.println("myThread has been stopped");
        });

        myThread.start();
        Thread.sleep(1);
        System.out.println("Main thread stops myThread");
        isRunning.set(true);
    }
}
