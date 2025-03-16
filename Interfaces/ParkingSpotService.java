package LowLevelDesign.ParkingLot.Interfaces;


import LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpot;
import LowLevelDesign.ParkingLot.Enum.ParkingLotEnum;

public interface ParkingSpotService {
    ParkingSpot create(ParkingLotEnum parkingLotEnum, int floor, int spotId);
}
