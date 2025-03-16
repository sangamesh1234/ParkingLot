package LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpotDecorator;


import LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpot;

public class Electric extends ParkingSpotDecorator {

    private ParkingSpot parkingSpot;

    public Electric(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    @Override
    public int cost(int parkingHours) {
        return parkingSpot.cost(parkingHours) + 30;
    }
}
