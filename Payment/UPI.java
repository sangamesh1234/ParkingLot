package LowLevelDesign.ParkingLot.Payment;

public class UPI implements Payment{

    @Override
    public boolean initiatePayment(int amount) {
        System.out.println("Initiating UPI Payment Successfully");
        return true;
    }
}
