package transport_task.vehicles;

public class Bike implements Vehicle {

    private String type;
    private boolean isRunning = false;

    public Bike(String type) {
        this.type = type;
    }

    @Override
    public void start() {
        isRunning = true;
        System.out.println("Bike starts running");
    }

    @Override
    public void stop() {
        isRunning = false;
        System.out.println("Bike stops running");
    }

    @Override
    public void displayInfo() {
        System.out.printf("Bike: type = %s, runningStatus = %s", type, isRunning);
    }
}
