package lld.parkinglot.model;

import java.time.LocalDateTime;

public class ParkingTicket {

    private final ParkingSpot parkingSpot;
    private final Vehicle vehicle;
    private final LocalDateTime entryTime;

    public ParkingTicket(ParkingSpot parkingSpot, Vehicle vehicle, LocalDateTime entryTime) {
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}
