package lld.parkinglot.strategy;

import lld.parkinglot.enums.VehicleType;
import lld.parkinglot.model.Floor;
import lld.parkinglot.model.ParkingSpot;

import java.util.List;

public class NearestSpotAvailableStrategy implements SpotFindingStrategy{

    @Override
    public ParkingSpot findSpot(List<Floor> floors, VehicleType vehicleType) {
        for(Floor floor : floors) {
            for(ParkingSpot spot : floor.getSpots()) {
                if (spot.canPark(vehicleType)) {
                    return spot;
                }
            }
        }
        return null;
    }
}
