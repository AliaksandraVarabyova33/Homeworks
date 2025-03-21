package tasks;

//Создай класс ParkingLot с Semaphore(3), где 5 машин пытаются припарковаться, но одновременно могут занять только 3 места.

import java.util.concurrent.Semaphore;

public class Task7 {

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        Thread car1 = new Thread(parkingLot::park);
        Thread car2 = new Thread(parkingLot::park);
        Thread car3 = new Thread(parkingLot::park);
        Thread car4 = new Thread(parkingLot::park);
        Thread car5 = new Thread(parkingLot::park);

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
    }

}

class ParkingLot {
    Semaphore semaphore = new Semaphore(3);

    void park() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "parking...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(Thread.currentThread().getName() + "releasing parking space...");
            semaphore.release();
        }
    }
}
