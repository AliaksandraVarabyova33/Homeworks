package transport_task.vehicles;

public class Car implements Vehicle {

    private String brand;
    private boolean isRunning = false;

    public Car(String brand) {
        this.brand = brand;
    }

    @Override
    public void start() {
        isRunning = true;
        System.out.println("Car starts running");
    }

    @Override
    public void stop() {
        isRunning = false;
        System.out.println("Car stops running");
    }

    @Override
    public void displayInfo() {
        System.out.printf("Car: brand = %s, runningStatus = %s", brand, isRunning);
    }
}
