package LowLevelDesign.ParkingLot.Strategy;

import LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpot;
import LowLevelDesign.ParkingLot.Enum.ParkingLotEnum;

public interface Strategy {
    ParkingSpot findParkingSpot(ParkingLotEnum vehicleType);
}
