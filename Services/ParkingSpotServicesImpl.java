package LowLevelDesign.ParkingLot.Services;

import LowLevelDesign.ParkingLot.DTO.ParkingLot;
import LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpot;
import LowLevelDesign.ParkingLot.Enum.ParkingLotEnum;
import LowLevelDesign.ParkingLot.Interfaces.DisplayBoardService;
import LowLevelDesign.ParkingLot.Interfaces.ParkingSpotService;

import java.lang.reflect.InvocationTargetException;

public class ParkingSpotServicesImpl implements ParkingSpotService {
    private DisplayBoardService displayServices = new DisplayServicesImpl();
    @Override
    public ParkingSpot create(ParkingLotEnum parkingLotEnum, int floor, int spotId) {
        try{
            ParkingSpot parkingSpot = (ParkingSpot) parkingLotEnum.getVehicleType().getConstructor(int.class, int.class).newInstance(floor,spotId);
            ParkingLot.getInstance().getFreeParkingSpots().get(parkingLotEnum).add(parkingSpot);
            displayServices.update(parkingLotEnum, 1);
            return parkingSpot;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
