package LowLevelDesign.ParkingLot.Vehicle;

import LowLevelDesign.ParkingLot.Enum.ParkingLotEnum;

public class Bike extends Vehicle {
    public Bike(int id) {
        super(id, ParkingLotEnum.MINI);
    }
}
