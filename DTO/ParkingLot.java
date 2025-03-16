package LowLevelDesign.ParkingLot.DTO;

import LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LowLevelDesign.ParkingLot.Enum.ParkingLotEnum;

public class ParkingLot {
    private String name;
    private String address;
    private List<Floor> floorList;
    private List<EntrancePanel> entrancePanelList;
    private List<ExitPanel> exitPanelList;
    private DisplayBoard displayBoard;
    private Map<ParkingLotEnum, List<ParkingSpot>> freeParkingSpots;
    private Map<ParkingLotEnum, List<ParkingSpot>> occupiedParkingSpots;

    private static ParkingLot parkingLot = null;

    private ParkingLot(String name, String address) {
        this.name = name;
        this.address = address;
        floorList = new ArrayList<>();
        entrancePanelList = new ArrayList<>();
        exitPanelList = new ArrayList<>();;
        displayBoard = DisplayBoard.getInstance();
        freeParkingSpots = new HashMap<>();
        occupiedParkingSpots = new HashMap<>();

        freeParkingSpots.put(ParkingLotEnum.MINI, new ArrayList<>());
        freeParkingSpots.put(ParkingLotEnum.COMPACT, new ArrayList<>());
        freeParkingSpots.put(ParkingLotEnum.LARGE, new ArrayList<>());

        occupiedParkingSpots.put(ParkingLotEnum.MINI, new ArrayList<>());
        occupiedParkingSpots.put(ParkingLotEnum.COMPACT, new ArrayList<>());
        occupiedParkingSpots.put(ParkingLotEnum.LARGE, new ArrayList<>());
    }

    public static ParkingLot getInstance(){
        if(parkingLot == null){
            synchronized (ParkingLot.class){
                if(parkingLot == null){
                    parkingLot = new ParkingLot("HSR Layout", "HSR Layout Bangalore");
                }
            }
        }
        return parkingLot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }

    public List<EntrancePanel> getEntrancePanelList() {
        return entrancePanelList;
    }

    public void setEntrancePanelList(List<EntrancePanel> entrancePanelList) {
        this.entrancePanelList = entrancePanelList;
    }

    public List<ExitPanel> getExitPanelList() {
        return exitPanelList;
    }

    public void setExitPanelList(List<ExitPanel> exitPanelList) {
        this.exitPanelList = exitPanelList;
    }

    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }

    public void setDisplayBoard(DisplayBoard displayBoard) {
        this.displayBoard = displayBoard;
    }

    public Map<ParkingLotEnum, List<ParkingSpot>> getFreeParkingSpots() {
        return freeParkingSpots;
    }

    public void setFreeParkingSpots(Map<ParkingLotEnum, List<ParkingSpot>> freeParkingSpots) {
        this.freeParkingSpots = freeParkingSpots;
    }

    public Map<ParkingLotEnum, List<ParkingSpot>> getOccupiedParkingSpots() {
        return occupiedParkingSpots;
    }

    public void setOccupiedParkingSpots(Map<ParkingLotEnum, List<ParkingSpot>> occupiedParkingSpots) {
        this.occupiedParkingSpots = occupiedParkingSpots;
    }
}
