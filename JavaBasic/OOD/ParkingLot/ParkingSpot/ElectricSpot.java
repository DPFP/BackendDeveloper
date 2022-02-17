package JavaBasic.OOD.ParkingLot.ParkingSpot;

import java.util.List;

import JavaBasic.OOD.ParkingLot.TicketProcess.ElectricPanel;

public class ElectricSpot extends ParkingSpot {
    public ElectricSpot() {
        super(ParkingSpotType.ELECTRIC);
    }

    List<ElectricPanel> electricPanels;
}
