package LowLevelDesign.ParkingLot.Services;

import LowLevelDesign.ParkingLot.DTO.ParkingLot;
import LowLevelDesign.ParkingLot.DTO.ParkingTicket;
import LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpot;
import LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpotDecorator.Electric;
import LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpotDecorator.Wash;
import LowLevelDesign.ParkingLot.Enum.ParkingLotEnum;
import LowLevelDesign.ParkingLot.Interfaces.DisplayBoardService;
import LowLevelDesign.ParkingLot.Interfaces.ParkingService;
import LowLevelDesign.ParkingLot.Strategy.Strategy;
import LowLevelDesign.ParkingLot.Vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ParkingServicesImpl implements ParkingService {
    private Strategy strategy;
    private DisplayBoardService displayServices;
    private ParkingLot parkingLot;

    public ParkingServicesImpl(Strategy strategy) {
        this.strategy = strategy;
        this.displayServices = new DisplayServicesImpl();
        this.parkingLot = ParkingLot.getInstance();
    }

    @Override
    public ParkingTicket entry(Vehicle vehicle) {
        ParkingLotEnum parkingLotEnum = vehicle.getVehicleType();
        List<ParkingSpot> freeParkingSpots = parkingLot.getFreeParkingSpots().get(parkingLotEnum);
        List<ParkingSpot> occupiedParkingSpots = parkingLot.getOccupiedParkingSpots().get(parkingLotEnum);
        ParkingTicket parkingTicket = null;
        try {
            ParkingSpot parkingSpot = strategy.findParkingSpot(parkingLotEnum);
            if(parkingSpot.isFree()){
                parkingSpot.setFree(false);
                occupiedParkingSpots.add(parkingSpot);
                freeParkingSpots.remove(parkingSpot);
                displayServices.update(parkingLotEnum,1);
                parkingTicket = new ParkingTicket(parkingSpot.getSpotId(), parkingSpot, vehicle, LocalDateTime.now());
            }
            return parkingTicket;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void exit(ParkingTicket parkingTicket, Vehicle vehicle) throws IllegalArgumentException{
        if(parkingTicket.getVehicle().equals(vehicle)){
            Map<ParkingLotEnum, List<ParkingSpot>> freeParkingSpots = parkingLot.getFreeParkingSpots();
            Map<ParkingLotEnum, List<ParkingSpot>> occupiedParkingSpots = parkingLot.getOccupiedParkingSpots();
            occupiedParkingSpots.get(vehicle.getVehicleType()).remove(parkingTicket.getParkingSpot());
            freeParkingSpots.get(vehicle.getVehicleType()).add(parkingTicket.getParkingSpot());
            displayServices.update(vehicle.getVehicleType(),1);
        }
        else{
            throw new IllegalArgumentException("Ticket ID " + parkingTicket.getVehicle() + " does not match vehicle ID " + vehicle);
        }
    }

    public void addWash(ParkingTicket parkingTicket){
        ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
        ParkingSpot parkingSpot1 = new Wash(parkingSpot);
        parkingTicket.setParkingSpot(parkingSpot1);
    }

    public void addElectric(ParkingTicket parkingTicket){
        ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
        ParkingSpot parkingSpot1 = new Electric(parkingSpot);
        parkingTicket.setParkingSpot(parkingSpot1);
    }
}
