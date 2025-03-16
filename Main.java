package LowLevelDesign.ParkingLot;

import LowLevelDesign.ParkingLot.DTO.DisplayBoard;
import LowLevelDesign.ParkingLot.DTO.ParkingLot;
import LowLevelDesign.ParkingLot.DTO.ParkingTicket;
import LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpot;
import LowLevelDesign.ParkingLot.DTO.Parkingspot.ParkingSpotDecorator.Electric;
import LowLevelDesign.ParkingLot.Exceptions.InvalidTicketException;
import LowLevelDesign.ParkingLot.Enum.ParkingLotEnum;
import LowLevelDesign.ParkingLot.Interfaces.ParkingSpotService;
import LowLevelDesign.ParkingLot.Interfaces.PaymentService;
import LowLevelDesign.ParkingLot.Services.ParkingServicesImpl;
import LowLevelDesign.ParkingLot.Services.ParkingSpotServicesImpl;
import LowLevelDesign.ParkingLot.Services.PaymentServiceImpl;
import LowLevelDesign.ParkingLot.Strategy.FarthestFirstStrategy;
import LowLevelDesign.ParkingLot.Vehicle.Car;
import LowLevelDesign.ParkingLot.Vehicle.Truck;
import LowLevelDesign.ParkingLot.Vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot= ParkingLot.getInstance();
        ParkingSpotService parkingSpotService= new ParkingSpotServicesImpl();

        ParkingSpot a1 = parkingSpotService.create(ParkingLotEnum.COMPACT, 0,1);
        ParkingSpot a2 = parkingSpotService.create(ParkingLotEnum.COMPACT, 0,2);

        ParkingSpot b1 = new Electric(parkingSpotService.create(ParkingLotEnum.LARGE, 0,3));
        ParkingSpot b2 = parkingSpotService.create(ParkingLotEnum.LARGE, 0,4);

        ParkingSpot c1 = parkingSpotService.create(ParkingLotEnum.MINI, 0,5);
        ParkingSpot c2 = parkingSpotService.create(ParkingLotEnum.MINI, 0,6);

        Vehicle v1= new Car(1);
        Vehicle v2= new Truck(2);

        ParkingServicesImpl parkingLotService = new ParkingServicesImpl(new FarthestFirstStrategy());
        PaymentService paymentService = new PaymentServiceImpl();

        ParkingTicket parkingTicket1 = parkingLotService.entry(v1);
        System.out.println("parking ticket 1: " +  parkingTicket1);
        System.out.println( "parking ticket 1 with vehicle id: " +  parkingTicket1.getVehicle().getVehicleId());
        System.out.println( parkingTicket1.getVehicle().equals(v1) );

        ParkingTicket parkingTicket2 = parkingLotService.entry(v2);
        parkingLotService.addWash(parkingTicket2);
        parkingLotService.addElectric(parkingTicket2);
        System.out.println("parking ticket 2: " +  parkingTicket2);
        System.out.println( "parking ticket 2 with vehicle id: " +  parkingTicket2.getVehicle().getVehicleId());

        try {
            parkingLotService.exit(parkingTicket2, v2);
            int cost = parkingTicket2.getParkingSpot().cost(parkingTicket2.getParkingHours());
            System.out.println("cost: "+ cost);
            paymentService.acceptCash(cost);
        } catch (InvalidTicketException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println(DisplayBoard.getInstance().toString());
        }
    }
}
