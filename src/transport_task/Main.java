package transport_task;

import transport_task.garage.Garage;
import transport_task.vehicles.Bike;
import transport_task.vehicles.Car;
import transport_task.vehicles.Motorcycle;
import transport_task.vehicles.Vehicle;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();

        Vehicle vehicle1 = new Car("Toyota");
        Vehicle vehicle2 = new Bike("Mountain");
        Vehicle vehicle3 = new Motorcycle(1.6);

        garage.addToGarage(vehicle1);
        garage.addToGarage(vehicle2);
        garage.addToGarage(vehicle3);

        garage.startVehicles();
        System.out.println("-----------------\n-----------------\n-----------------");
        garage.stopVehicles();
    }
}
