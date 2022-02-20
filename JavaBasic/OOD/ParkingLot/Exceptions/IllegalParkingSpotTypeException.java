package JavaBasic.OOD.ParkingLot.Exceptions;

public class IllegalParkingSpotTypeException extends Exception {
    @Override
    public String getMessage() {
        return super.getMessage() + "Illegal ParkingSpotType Exception";
    }
}
