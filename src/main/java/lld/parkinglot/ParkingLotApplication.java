package lld.parkinglot;

import lld.parkinglot.config.ParkingLotConfiguration;
import lld.parkinglot.enums.VehicleType;
import lld.parkinglot.model.ParkingLot;
import lld.parkinglot.model.ParkingTicket;
import lld.parkinglot.model.Vehicle;
import lld.parkinglot.strategy.HourlyFeeCalculatingStrategy;
import lld.parkinglot.strategy.NearestSpotAvailableStrategy;

public class ParkingLotApplication {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = new ParkingLot(
                new ParkingLotConfiguration(
                        0, 0,
                        1, 1,
                        0, 0),
                new NearestSpotAvailableStrategy(),
                new HourlyFeeCalculatingStrategy());

        Vehicle swift = new Vehicle("AB123", VehicleType.CAR);

        ParkingTicket swiftTicket = parkingLot.parkVehicle(swift);

//        Vehicle dzire = new Vehicle("XY987", VehicleType.CAR);
//
//        parkingLot.parkVehicle(dzire);

        Thread.sleep(10000);

        System.out.println(parkingLot.releaseVehicle(swiftTicket));
    }
}
