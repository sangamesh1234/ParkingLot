package LowLevelDesign.ParkingLot.Payment;

public class Cash implements Payment{
    @Override
    public boolean initiatePayment(int amount) {
        System.out.println("Initiating Cash Payment Successfully");
        return true;
    }
}
