package lld.parkinglot.strategy;

import lld.parkinglot.enums.VehicleType;
import lld.parkinglot.model.Floor;
import lld.parkinglot.model.ParkingSpot;

import java.util.List;

public interface SpotFindingStrategy {
    ParkingSpot findSpot(List<Floor> floors, VehicleType vehicleType);
}
