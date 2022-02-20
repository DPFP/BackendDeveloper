package JavaBasic.OOD.ParkingLot;

import java.util.HashMap;
import java.util.List;

import JavaBasic.OOD.ParkingLot.DataEntity.Location;
import JavaBasic.OOD.ParkingLot.TicketProcess.EntrancePanel;
import JavaBasic.OOD.ParkingLot.TicketProcess.ExitPanel;
import JavaBasic.OOD.ParkingLot.TicketProcess.ParkingAttendantPortal;
import JavaBasic.OOD.ParkingLot.TicketProcess.ParkingTicket;

//https://akshay-iyangar.github.io/system-design/grokking-ood/examples/java/parking-lot.html

public class ParkingLot {
    private String id;
    private Location address; // dataType (POJO)
    private List<ParkingRate> parkingRate; // composition

    private int compactSpotCount;
    private int largeSpotCount;
    private int motorbikeSpotCount;
    private int electricSpotCount;
    private final int maxCompactCount;
    private final int maxLargeCount;
    private final int maxMotorbikeCount;
    private final int maxElectricCount;

    private HashMap<String, EntrancePanel> entrancePanel; // composition
    private HashMap<String, ExitPanel> exitPanel; // composition
    private HashMap<String, ParkingFloor> parkingLoor; // composition

    // active tickets
    private HashMap<String, ParkingTicket> parkingTicket; // composition

    // missing from the class impl?
    private List<ParkingAttendantPortal> parkingAttendantPortal; // composition

    // singleton
    private static ParkingLot parkingLot = null;

    // prevent create more than one
    private ParkingLot(int maxCompactCount, int maxLargeCount, int maxMotorbikeCount, int maxElectricCount) {
        //
        this.maxCompactCount = maxCompactCount;
        this.maxLargeCount = maxLargeCount;
        this.maxMotorbikeCount = maxMotorbikeCount;
        this.maxElectricCount = maxElectricCount;
    }

    public static ParkingLot getInstance(int maxCompactCount, int maxLargeCount, int maxMotorbikeCount,
            int maxElectricCount) {
        if (parkingLot == null) {
            parkingLot = new ParkingLot(maxCompactCount, maxLargeCount, maxMotorbikeCount, maxElectricCount);
        }

        return parkingLot;
    }

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
