package LowLevelDesign.ParkingLot.Exceptions;

public class SpotNotFoundException extends RuntimeException {
    public SpotNotFoundException(String message) {
        super(message);
    }
}
