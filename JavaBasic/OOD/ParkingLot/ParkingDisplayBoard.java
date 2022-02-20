package JavaBasic.OOD.ParkingLot;

import JavaBasic.OOD.ParkingLot.ParkingSpot.CompactSpot;
import JavaBasic.OOD.ParkingLot.ParkingSpot.ElectricSpot;
import JavaBasic.OOD.ParkingLot.ParkingSpot.HandicappedSpot;
import JavaBasic.OOD.ParkingLot.ParkingSpot.LargeSpot;
import JavaBasic.OOD.ParkingLot.ParkingSpot.MotorbikeSpot;
import JavaBasic.OOD.ParkingLot.ParkingSpot.ParkingSpot;

public class ParkingDisplayBoard {
    private String id;
    private HandicappedSpot handicappedFreeSpot;
    private CompactSpot compactFreeSpot;
    private LargeSpot largeFreeSpot;
    private MotorbikeSpot motorbikeFreeSpot;
    private ElectricSpot electricFreeSpot;

    public void showEmptySpotNumber() {
        String message = "";
        if (handicappedFreeSpot.IsFree()) {
            message += "Free Handicapped: " + handicappedFreeSpot.getNumber();
        } else {
            message += "Handicapped is full";
        }
        message += System.lineSeparator();

        if (compactFreeSpot.IsFree()) {
            message += "Free Compact: " + compactFreeSpot.getNumber();
        } else {
            message += "Compact is full";
        }
        message += System.lineSeparator();

        if (largeFreeSpot.IsFree()) {
            message += "Free Large: " + largeFreeSpot.getNumber();
        } else {
            message += "Large is full";
        }
        message += System.lineSeparator();

        if (motorbikeFreeSpot.IsFree()) {
            message += "Free Motorbike: " + motorbikeFreeSpot.getNumber();
        } else {
            message += "Motorbike is full";
        }
        message += System.lineSeparator();

        if (electricFreeSpot.IsFree()) {
            message += "Free Electric: " + electricFreeSpot.getNumber();
        } else {
            message += "Electric is full";
        }

        Show(message);
    }

    private void Show(String message) {
    }

    public ParkingSpot getHandicappedFreeSpot() {
        return null;
    }

    public void setHandicappedFreeSpot(HandicappedSpot handicappedSpot) {
    }

    public ParkingSpot getCompactFreeSpot() {
        return null;
    }

    public void setCompactFreeSpot(CompactSpot compactSpot) {
    }
}
