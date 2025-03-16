package LowLevelDesign.ParkingLot.Interfaces;

import LowLevelDesign.ParkingLot.Enum.ParkingLotEnum;

public interface DisplayBoardService {
    void update(ParkingLotEnum parkingLotEnum, int count);
}
