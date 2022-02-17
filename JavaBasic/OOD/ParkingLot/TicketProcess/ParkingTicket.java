package JavaBasic.OOD.ParkingLot.TicketProcess;

import java.time.LocalDateTime;

public class ParkingTicket {
    private String ticketNumber;
    private LocalDateTime issuedAt;
    private LocalDateTime payedAt;
    private double payedAmount;
    private ParkingTicketStatus status; // Enum
}
