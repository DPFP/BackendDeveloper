package JavaBasic.OOD.ParkingLot.Vehicle;

import JavaBasic.OOD.ParkingLot.TicketProcess.ParkingTicket;

public class Vehicle {
    private String licenseNumber; // plateNumber;
    private final VehicleType type; // need be final
    private ParkingTicket parkingTicket;

    // misisng default constructor which used set the type
    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public void assignTicket(ParkingTicket ticket) {
        this.parkingTicket = ticket;
    }
}
