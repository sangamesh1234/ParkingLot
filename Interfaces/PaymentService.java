package LowLevelDesign.ParkingLot.Interfaces;


public interface PaymentService {
    boolean acceptCash(int amount);

    boolean card(int cvv, int pinCode, int amount);

    boolean UPIMethod(int pinCode, int amount);
}
