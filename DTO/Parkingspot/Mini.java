package LowLevelDesign.ParkingLot.DTO.Parkingspot;

public class Mini extends ParkingSpot {

    public Mini(int floor, int spotId) {
        super(floor, spotId);
    }

    @Override
    public int cost(int parkingHours) {
        return parkingHours * 10;
    }
}
