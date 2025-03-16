package LowLevelDesign.ParkingLot.Interfaces;

import LowLevelDesign.ParkingLot.DTO.ParkingTicket;
import LowLevelDesign.ParkingLot.Vehicle.Vehicle;

public interface ParkingService {
    ParkingTicket entry(Vehicle vehicle);
    void exit(ParkingTicket parkingTicket, Vehicle vehicle);
}
