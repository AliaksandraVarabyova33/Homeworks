package transport_task.garage;

import transport_task.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    List<Vehicle> vehicles;

    public Garage() {
        vehicles = new ArrayList<>();
    }

    public void addToGarage(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void showVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
        }
    }


    public void startVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.displayInfo();
            System.out.println();
        }
    }

    public void stopVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stop();
            vehicle.displayInfo();
            System.out.println();
        }
    }

}
