package LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpotDecorator;

import LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpot;

public class Wash extends ParkingSpotDecorator {

    private ParkingSpot parkingSpot;

    public Wash(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    @Override
    public int cost(int parkingHours) {
        return parkingSpot.cost(parkingHours) + 60;
    }
}
