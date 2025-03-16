package LowLevelDesign.ParkingLot.Services;

import LowLevelDesign.ParkingLot.Interfaces.PaymentService;
import LowLevelDesign.ParkingLot.Payment.Card;
import LowLevelDesign.ParkingLot.Payment.Cash;
import LowLevelDesign.ParkingLot.Payment.Payment;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public boolean acceptCash(int amount) {
       Payment payment = new Cash();
       return payment.initiatePayment(amount);
    }

    @Override
    public boolean card(int cvv, int pinCode, int amount) {
        Payment payment = new Card();
        return payment.initiatePayment(amount);
    }

    @Override
    public boolean UPIMethod(int pinCode, int amount) {
        Payment payment = new Card();
        return payment.initiatePayment(amount);
    }
}
