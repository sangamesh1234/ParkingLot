package LowLevelDesign.ParkingLot.Vehicle;

import LowLevelDesign.ParkingLot.Enum.ParkingLotEnum;

public class Car extends Vehicle {

    public Car(int id) {
        super(id, ParkingLotEnum.COMPACT);
    }
}
