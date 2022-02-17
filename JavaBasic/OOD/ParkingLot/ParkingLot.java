package JavaBasic.OOD.ParkingLot;

import java.util.List;

import JavaBasic.OOD.ParkingLot.DataEntity.Location;
import JavaBasic.OOD.ParkingLot.TicketProcess.EntrancePanel;
import JavaBasic.OOD.ParkingLot.TicketProcess.ExitPanel;
import JavaBasic.OOD.ParkingLot.TicketProcess.ParkingAttendantPortal;
import JavaBasic.OOD.ParkingLot.TicketProcess.ParkingTicket;

public class ParkingLot {
    private String id;
    private Location address; // dataType (POJO)

    private List<ParkingRate> parkingRate; // composition
    private List<ParkingTicket> parkingTicket; // composition
    private List<EntrancePanel> entrancePanel; // composition
    private List<ExitPanel> exitPanel; // composition
    private List<ParkingAttendantPortal> parkingAttendantPortal; // composition
    private List<ParkingFloor> parkingLoor; // composition

    public boolean addParkingFloor() {
        // TODO
        return false;
    }

    public boolean addEntrancePanel() {
        return false;
    }

    public ParkingTicket getParkingTicket() {
        return null;
    }

    public boolean isFull() {
        return false;
    }
}
