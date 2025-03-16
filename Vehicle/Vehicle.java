package LowLevelDesign.ParkingLot.Vehicle;

import LowLevelDesign.ParkingLot.Enum.ParkingLotEnum;

public abstract class Vehicle {
    private int vehicleId;
    private ParkingLotEnum vehicleType;

    public Vehicle(int vehicleId, ParkingLotEnum vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public ParkingLotEnum getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(ParkingLotEnum vehicleType) {
        this.vehicleType = vehicleType;
    }
}
