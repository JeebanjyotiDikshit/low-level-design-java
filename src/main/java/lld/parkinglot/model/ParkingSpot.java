package lld.parkinglot.model;

import lld.parkinglot.enums.ParkingSpotType;
import lld.parkinglot.enums.VehicleType;

public class ParkingSpot {
    private final int floorNumber;
    private final String parkingSpotNumber;
    private Vehicle parkedVehicle;
    private final ParkingSpotType parkingSpotType;

    public ParkingSpot(int floorNumber, String parkingSpotNumber,
                       ParkingSpotType parkingSpotType) {
        this.floorNumber = floorNumber;
        this.parkingSpotNumber = parkingSpotNumber;
        this.parkingSpotType = parkingSpotType;
    }

    public boolean isOccupied() {
        return parkedVehicle != null;
    }

    private boolean isCompatible(VehicleType vehicleType) {
        return (parkingSpotType == ParkingSpotType.BIKE_SPOT && vehicleType == VehicleType.BIKE) ||
                (parkingSpotType == ParkingSpotType.CAR_SPOT && vehicleType == VehicleType.CAR) ||
                (parkingSpotType == ParkingSpotType.TRUCK_SPOT && vehicleType == VehicleType.TRUCK);
    }

    public boolean canPark(VehicleType vehicleType) {
        return !isOccupied() && isCompatible(vehicleType);
    }

    public void parkVehicle(Vehicle vehicle) {
        if (canPark(vehicle.getVehicleType())) {
            parkedVehicle = vehicle;
        }
    }

    public void freeUp() {
        parkedVehicle = null;
    }

    //getters
    public int getFloorNumber() {
        return floorNumber;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

}
