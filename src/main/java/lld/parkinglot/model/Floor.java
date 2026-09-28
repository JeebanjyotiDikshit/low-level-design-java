package lld.parkinglot.model;

import java.util.List;

public class Floor {

    private final int floorNumber;
    private final List<ParkingSpot> spots;

    public Floor(int floorNumber, List<ParkingSpot> spots) {
        this.floorNumber = floorNumber;
        this.spots = spots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }
}
