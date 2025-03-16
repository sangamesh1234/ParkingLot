package LowLevelDesign.ParkingLot.Services;

import LowLevelDesign.ParkingLot.DTO.DisplayBoard;
import LowLevelDesign.ParkingLot.Enum.ParkingLotEnum;
import LowLevelDesign.ParkingLot.Interfaces.DisplayBoardService;

public class DisplayServicesImpl implements DisplayBoardService {
    @Override
    public void update(ParkingLotEnum parkingLotEnum, int change) {
        int currentCount = DisplayBoard.getInstance().getFreeParkingSpots().getOrDefault(parkingLotEnum,0);
        int newCount = currentCount + change;
        DisplayBoard.getInstance().getFreeParkingSpots().replace(parkingLotEnum, newCount);
    }
}
