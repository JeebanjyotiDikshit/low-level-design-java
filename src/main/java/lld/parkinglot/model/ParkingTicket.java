package lld.parkinglot.model;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ParkingTicket)) {
            return false;
        }

        ParkingTicket other = (ParkingTicket) obj;

        return this.parkingSpot.getParkingSpotNumber()
                .equals(other.parkingSpot.getParkingSpotNumber())
                && this.vehicle.getVehicleNumber()
                .equals(other.vehicle.getVehicleNumber())
                && this.entryTime.equals(other.entryTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                parkingSpot.getParkingSpotNumber(),
                vehicle.getVehicleNumber(),
                entryTime
        );
    }
}
