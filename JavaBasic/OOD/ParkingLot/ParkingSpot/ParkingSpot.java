package JavaBasic.OOD.ParkingLot.ParkingSpot;

import JavaBasic.OOD.ParkingLot.Vehicle.Vehicle;

public class ParkingSpot {
    private String number; // id
    private boolean free;
    private final ParkingSpotType type; // need be final, since it won't change forever
    private Vehicle vehicle;

    // initial the final value at the constructor
    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public boolean IsFree() {
        return false;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpotType getType() {
        return type;
    }

    // misisng from diagram
    public void setFree(boolean free) {
        this.free = free;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        this.setVehicle(vehicle);
        setFree(false);

        return true;
    }

    public boolean removeVehicle() {
        this.setVehicle(null);
        setFree(true);

        return true;
    }
}
