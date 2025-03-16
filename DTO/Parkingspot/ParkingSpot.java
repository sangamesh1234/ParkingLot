package LowLevelDesign.ParkingLot.DTO.Parkingspot;

public abstract class ParkingSpot {
    private int floor;
    private int spotId;
    private boolean isFree;

    public ParkingSpot(){

    }

    public ParkingSpot(int floor, int spotId) {
        this.floor = floor;
        this.spotId = spotId;
        this.isFree = true;
    }

    public abstract int cost(int parkingHours);

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
