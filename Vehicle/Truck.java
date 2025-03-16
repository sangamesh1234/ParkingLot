package LowLevelDesign.ParkingLot.Vehicle;

import LowLevelDesign.ParkingLot.Enum.ParkingLotEnum;

public class Truck extends Vehicle {
    public Truck(int id){
        super(id, ParkingLotEnum.LARGE);
    }
}
