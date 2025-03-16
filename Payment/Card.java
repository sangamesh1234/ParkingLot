package LowLevelDesign.ParkingLot.Payment;

public class Card implements Payment{

    @Override
    public boolean initiatePayment(int amount) {
        System.out.println("Initiating Card Payment Successfully");
        return true;
    }
}
