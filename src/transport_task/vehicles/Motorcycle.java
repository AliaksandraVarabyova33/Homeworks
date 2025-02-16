package transport_task.vehicles;

public class Motorcycle implements Vehicle {
    private double engineCapacity;
    private boolean isRunning = false;

    public Motorcycle(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void start() {
        isRunning = true;
        System.out.println("Motocycle starts running");
    }

    @Override
    public void stop() {
        isRunning = false;
        System.out.println("Motocycle stops running");
    }

    @Override
    public void displayInfo() {
        System.out.printf("Motorcycle: engineCapacity = %.1f, runningStatus = %s", engineCapacity, isRunning);
    }
}
