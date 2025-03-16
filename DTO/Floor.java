package LowLevelDesign.ParkingLot.DTO;

import LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpot;

import java.util.List;

public class Floor {
    int floorId;
    List<ParkingSpot> parkingSpotList;

    public Floor(int floorId, List<ParkingSpot> parkingSpotList) {
        this.floorId = floorId;
        this.parkingSpotList = parkingSpotList;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }
}
