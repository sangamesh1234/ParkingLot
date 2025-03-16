package LowLevelDesign.ParkingLot.DTO.Parkingspot;

public class Compact extends ParkingSpot {

    public Compact(int floor, int spotId) {
        super(floor, spotId);
    }

    @Override
    public int cost(int parkingHours) {
        return parkingHours * 20;
    }
}
