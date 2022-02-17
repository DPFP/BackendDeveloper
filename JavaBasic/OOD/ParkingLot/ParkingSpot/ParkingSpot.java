package JavaBasic.OOD.ParkingLot.ParkingSpot;

import JavaBasic.OOD.ParkingLot.Vehicle.Vehicle;

public class ParkingSpot {
    private String number; // id
    private boolean free;
    private final ParkingSpotType type; // need be final, since it won't change forever
    private Vehicle vehicle;

    public boolean isFree() {
        return false;
    }

    // misisng from diagram

    // initial the final value at the constructor
    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;

        return true;
    }

    public boolean removeVehicle() {
        this.vehicle = null;
        free = true;

        return true;
    }
}
