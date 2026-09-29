package lld.parkinglot.exception;

public class NoSuitableParkingSpotAvailableException extends RuntimeException {
    public NoSuitableParkingSpotAvailableException(String message) {
        super(message);
    }
}
