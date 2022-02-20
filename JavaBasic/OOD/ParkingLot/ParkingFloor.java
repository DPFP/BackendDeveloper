package JavaBasic.OOD.ParkingLot;

import java.util.HashMap;
import java.util.List;

import JavaBasic.OOD.ParkingLot.Exceptions.IllegalParkingSpotTypeException;
import JavaBasic.OOD.ParkingLot.ParkingSpot.CompactSpot;
import JavaBasic.OOD.ParkingLot.ParkingSpot.ElectricSpot;
import JavaBasic.OOD.ParkingLot.ParkingSpot.HandicappedSpot;
import JavaBasic.OOD.ParkingLot.ParkingSpot.LargeSpot;
import JavaBasic.OOD.ParkingLot.ParkingSpot.MotorbikeSpot;
import JavaBasic.OOD.ParkingLot.ParkingSpot.ParkingSpot;
import JavaBasic.OOD.ParkingLot.ParkingSpot.ParkingSpotType;
import JavaBasic.OOD.ParkingLot.TicketProcess.CustomerInfoPanel;
import JavaBasic.OOD.ParkingLot.Vehicle.Vehicle;

public class ParkingFloor {
    private String name; // floor Number ?
    private ParkingDisplayBoard displayBoard; // from the diagram it is should be a list

    // private List<ParkingSpot> parkingSpots;
    // private List<CustomerInfoPanel> customerInfoPortals;

    // use this instead
    private HashMap<String, HandicappedSpot> handicappedSpots;
    private HashMap<String, CompactSpot> compactSpots;
    private HashMap<String, LargeSpot> largeSpots;
    private HashMap<String, MotorbikeSpot> motorbikeSpots;
    private HashMap<String, ElectricSpot> electricSpots;
    private HashMap<String, CustomerInfoPanel> infoPortals;

    private int freeHandicappedSpotCount;
    private int freeCompactSpotCount;
    private int freeLargeSpotCount;
    private int freeMotorbikeSpotCount;
    private int freeElectricSpotCount;

    public void updateDisplayBoard() {

    }

    // what properties dose this need to take ? (Type ?)
    public void addParkingSlot(ParkingSpot spot) throws IllegalParkingSpotTypeException {
        switch (spot.getType()) {
            case HANDICAPPED:
                handicappedSpots.put(spot.getNumber(), (HandicappedSpot) spot); // why need cast ?
                break;
            case COMPACT:
                compactSpots.put(spot.getNumber(), (CompactSpot) spot);
                break;
            case LARGE:
                largeSpots.put(spot.getNumber(), (LargeSpot) spot);
                break;
            case MOTORBIKE:
                motorbikeSpots.put(spot.getNumber(), (MotorbikeSpot) spot);
                break;
            case ELECTRIC:
                electricSpots.put(spot.getNumber(), (ElectricSpot) spot);
                break;
            default: // throw some sort of exception
                throw new IllegalParkingSpotTypeException();
            // print("Wrong parking spot type!");
        }
    }

    // Should this return boolean ? and taking car/slot info ? make sure it fit ?
    public void assignVehicleToSlot(Vehicle vehicle, ParkingSpot spot) throws IllegalParkingSpotTypeException {
        spot.assignVehicle(vehicle);
        switch (spot.getType()) {
            case HANDICAPPED:
                updateDisplayBoardForHandicapped(spot);
                break;
            case COMPACT:
                updateDisplayBoardForCompact(spot);
                break;
            case LARGE:
                updateDisplayBoardForLarge(spot);
                break;
            case MOTORBIKE:
                updateDisplayBoardForMotorbike(spot);
                break;
            case ELECTRIC:
                updateDisplayBoardForElectric(spot);
                break;
            default:
                throw new IllegalParkingSpotTypeException();
            // print("Wrong parking spot type!");
        }
    }

    private void updateDisplayBoardForElectric(ParkingSpot spot) {
    }

    private void updateDisplayBoardForMotorbike(ParkingSpot spot) {
    }

    private void updateDisplayBoardForLarge(ParkingSpot spot) {
    }

    private void updateDisplayBoardForHandicapped(ParkingSpot spot) {
        if (this.displayBoard.getHandicappedFreeSpot().getNumber() == spot.getNumber()) {
            // find another free handicapped parking and assign to displayBoard
            for (String key : handicappedSpots.keySet()) {
                if (handicappedSpots.get(key).IsFree()) {
                    this.displayBoard.setHandicappedFreeSpot(handicappedSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    private void updateDisplayBoardForCompact(ParkingSpot spot) {
        if (this.displayBoard.getCompactFreeSpot().getNumber() == spot.getNumber()) {
            // find another free compact parking and assign to displayBoard
            for (String key : compactSpots.keySet()) {
                if (compactSpots.get(key).IsFree()) {
                    this.displayBoard.setCompactFreeSpot(compactSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    // should this also update the free-available spot ?
    public void freeSlot(ParkingSpot spot) throws IllegalParkingSpotTypeException {
        spot.removeVehicle();
        switch (spot.getType()) {
            case HANDICAPPED:
                freeHandicappedSpotCount++;
                break;
            case COMPACT:
                freeCompactSpotCount++;
                break;
            case LARGE:
                freeLargeSpotCount++;
                break;
            case MOTORBIKE:
                freeMotorbikeSpotCount++;
                break;
            case ELECTRIC:
                freeElectricSpotCount++;
                break;
            default:
                // print("Wrong parking spot type!");
                throw new IllegalParkingSpotTypeException();
        }
    }
}
