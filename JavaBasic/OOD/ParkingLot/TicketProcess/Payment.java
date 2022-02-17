package JavaBasic.OOD.ParkingLot.TicketProcess;

import java.time.LocalDateTime;

public class Payment {
    private LocalDateTime creationDate;
    private double amount;
    private PaymentStatus status;

    public boolean initialTransaction() {
        return false;
    }
}
