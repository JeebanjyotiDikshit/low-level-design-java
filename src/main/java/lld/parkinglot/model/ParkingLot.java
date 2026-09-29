package lld.parkinglot.model;

import lld.parkinglot.config.ParkingLotConfiguration;
import lld.parkinglot.exception.InvalidParkingTicketException;
import lld.parkinglot.exception.NoSuitableParkingSpotAvailableException;
import lld.parkinglot.exception.VehicleAlreadyParkedException;
import lld.parkinglot.strategy.FeeCalculatingStrategy;
import lld.parkinglot.strategy.SpotFindingStrategy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private final List<Floor> floors;
    private final Map<String, ParkingTicket> activeTickets;
    private final SpotFindingStrategy spotFindingStrategy;
    private final FeeCalculatingStrategy feeCalculatingStrategy;

    public ParkingLot(ParkingLotConfiguration parkingLotConfiguration,
                      SpotFindingStrategy spotFindingStrategy,
                      FeeCalculatingStrategy feeCalculatingStrategy) {
        this.floors = parkingLotConfiguration.configureFloors();
        this.activeTickets = new HashMap<>();
        this.spotFindingStrategy = spotFindingStrategy;
        this.feeCalculatingStrategy = feeCalculatingStrategy;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        if (activeTickets.containsKey(vehicle.getVehicleNumber())) {
            throw new VehicleAlreadyParkedException("The Vehicle is already parked!");
        }

        ParkingSpot spot = spotFindingStrategy.findSpot(floors, vehicle.getVehicleType());

        if (spot == null) {
            throw new NoSuitableParkingSpotAvailableException("No suitable parking spot is available at the moment!!");
        }

        spot.parkVehicle(vehicle);

        ParkingTicket ticket = new ParkingTicket(spot, vehicle, LocalDateTime.now());

        activeTickets.put(vehicle.getVehicleNumber(), ticket);

        return ticket;
    }

    private boolean verifyTicket(ParkingTicket incomingTicket) {
        if (!activeTickets.containsKey(incomingTicket.getVehicle().getVehicleNumber())) {
            return false;
        }

        ParkingTicket storedTicket = activeTickets.get(incomingTicket.getVehicle().getVehicleNumber());
        return storedTicket.equals(incomingTicket);
    }

    public double releaseVehicle(ParkingTicket ticket) {
        if (!verifyTicket(ticket)) {
            throw new InvalidParkingTicketException("The parking ticket is invalid!");
        }

        LocalDateTime exitTime = LocalDateTime.now();

        double parkingFee =
                feeCalculatingStrategy.calculateFee(ticket.getParkingSpot().getParkingSpotType(),
                        ticket.getEntryTime(), exitTime);

        ticket.getParkingSpot().freeUp();

        activeTickets.remove(ticket.getVehicle().getVehicleNumber());

        return parkingFee;
    }
}
