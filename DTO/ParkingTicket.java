package LowLevelDesign.ParkingLot.DTO;

import LowLevelDesign.ParkingLot.Vehicle.Vehicle;
import LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpot;

import java.time.LocalDateTime;

public class ParkingTicket {
    private int ticketId;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private LocalDateTime timestamp;

    public ParkingTicket(int ticketId, ParkingSpot parkingSpot,
                         Vehicle vehicle, LocalDateTime timestamp) {
        this.ticketId = ticketId;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.timestamp = timestamp;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getParkingHours(){
        return 2;
    }
}
