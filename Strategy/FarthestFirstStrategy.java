package LowLevelDesign.ParkingLot.Strategy;

import LowLevelDesign.ParkingLot.DTO.ParkingLot;
import LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpot;
import LowLevelDesign.ParkingLot.Enum.ParkingLotEnum;
import LowLevelDesign.ParkingLot.Exceptions.SpotNotFoundException;

import java.util.List;

public class FarthestFirstStrategy implements Strategy{

    @Override
    public ParkingSpot findParkingSpot(ParkingLotEnum vehicleType) throws SpotNotFoundException{
        List<ParkingSpot> parkingSpots = ParkingLot.getInstance().getFreeParkingSpots().get(vehicleType);
        if(parkingSpots.size()==0){
            throw new SpotNotFoundException("Spot not found in nearest first strategy");
        }
        return parkingSpots.get(parkingSpots.size()-1);
    }
}
