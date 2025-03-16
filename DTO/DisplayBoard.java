package LowLevelDesign.ParkingLot.DTO;

import LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpot;
import LowLevelDesign.ParkingLot.Enum.ParkingLotEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayBoard {

    private static DisplayBoard displayBoard = null;
    private Map<ParkingLotEnum, Integer> freeParkingLots = new HashMap<>();

    private DisplayBoard() {

    }

    public static DisplayBoard getInstance() {
        if (displayBoard == null) {
            synchronized (DisplayBoard.class) {
                if (displayBoard == null) {
                    displayBoard = new DisplayBoard();
                }
            }
        }
        return displayBoard;
    }

    public Map<ParkingLotEnum, Integer> getFreeParkingSpots() {
        Map<ParkingLotEnum, List<ParkingSpot>> parkingLotLists = ParkingLot.getInstance().getFreeParkingSpots();
        for (ParkingLotEnum spot : ParkingLotEnum.values()) {
            List<ParkingSpot> parkingSpotList = parkingLotLists.get(spot);
            if (parkingSpotList != null) {
                freeParkingLots.put(spot, parkingSpotList.size());
            }
        }
        return freeParkingLots;
    }

    @Override
    public String toString() {
        freeParkingLots = getFreeParkingSpots();
        return "DisplayBoard{" +
                "freeParkingLots=" + freeParkingLots +
                '}';
    }
}
