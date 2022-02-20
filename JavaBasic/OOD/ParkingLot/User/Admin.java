package JavaBasic.OOD.ParkingLot.User;

import JavaBasic.OOD.ParkingLot.ParkingDisplayBoard;
import JavaBasic.OOD.ParkingLot.ParkingFloor;
import JavaBasic.OOD.ParkingLot.ParkingSpot.ParkingSpot;
import JavaBasic.OOD.ParkingLot.TicketProcess.CustomerInfoPanel;
import JavaBasic.OOD.ParkingLot.TicketProcess.EntrancePanel;
import JavaBasic.OOD.ParkingLot.TicketProcess.ExitPanel;

public class Admin extends Account {

    // should this also take some ParkingFloor properties ? like id/name ? Yes !
    // looks like all the method are omit the parameter from the diagram
    public boolean addParkingFloor(ParkingFloor floor) {
        return false;
    }

    // Missing from the diagram, but it should also included all the following
    public boolean addParkingSpot(String floorName, ParkingSpot spot) {
        return false;
    }

    public boolean addParkingDisplayBoard(String floorName, ParkingDisplayBoard displayBoard) {
        return false;
    }

    public boolean addCustomerInfoPanel(String floorName, CustomerInfoPanel infoPanel) {
        return false;
    }

    public boolean addEntrancePanel(EntrancePanel entrancePanel) {
        return false;
    }

    public boolean addExitPanel(ExitPanel exitPanel) {
        return false;
    }
}
