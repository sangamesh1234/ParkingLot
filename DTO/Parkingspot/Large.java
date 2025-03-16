package LowLevelDesign.ParkingLot.DTO.Parkingspot;

public class Large extends ParkingSpot {

    public Large(int floor, int spotId) {
        super(floor, spotId);
    }

    @Override
    public int cost(int parkingHours) {
        return parkingHours * 30;
    }
}
