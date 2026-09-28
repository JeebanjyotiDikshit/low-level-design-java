package lld.parkinglot.config;

import lld.parkinglot.enums.ParkingSpotType;
import lld.parkinglot.model.Floor;
import lld.parkinglot.model.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotConfiguration {
    private final int bikeFloorCount;
    private final int bikeSpotsOnBikeFloor;

    private final int carFloorCount;
    private final int carSpotsOnCarFloor;

    private final int truckFloorCount;
    private final int truckSpotsOnTruckFloor;

    public ParkingLotConfiguration(int bikeFloorCount, int bikeSpotsOnBikeFloor,
                                   int carFloorCount, int carSpotsOnCarFloor,
                                   int truckFloorCount, int truckSpotsOnTruckFloor) {
        this.bikeFloorCount = bikeFloorCount;
        this.bikeSpotsOnBikeFloor = bikeSpotsOnBikeFloor;
        this.carFloorCount = carFloorCount;
        this.carSpotsOnCarFloor = carSpotsOnCarFloor;
        this.truckFloorCount = truckFloorCount;
        this.truckSpotsOnTruckFloor = truckSpotsOnTruckFloor;
    }

    private Floor createFloor(int floorNumber, int spotCount,
                              String spotPrefix, ParkingSpotType parkingSpotType) {
        List<ParkingSpot> spots = new ArrayList<>();
        for(int i = 1; i <= spotCount; i++) {
            spots.add(new ParkingSpot(
                    floorNumber, spotPrefix + i, parkingSpotType
            ));
        }
        return new Floor(floorNumber, spots);
    }

    public List<Floor> configureFloors() {
        List<Floor> floors = new ArrayList<>();

        int floorNumber = 1;
        for(int i = 1; i <= bikeFloorCount; i++, floorNumber++) {
            floors.add(createFloor(floorNumber, bikeSpotsOnBikeFloor,
                    "B", ParkingSpotType.BIKE_SPOT));
        }
        for(int i = 1; i <= carFloorCount; i++, floorNumber++) {
            floors.add(createFloor(floorNumber, carSpotsOnCarFloor,
                    "C", ParkingSpotType.CAR_SPOT));
        }
        for(int i = 1; i <= truckFloorCount; i++, floorNumber++) {
            floors.add(createFloor(floorNumber, truckSpotsOnTruckFloor,
                    "T", ParkingSpotType.TRUCK_SPOT));
        }

        return floors;
    }
}
