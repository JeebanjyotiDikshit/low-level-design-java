package lld.parkinglot.strategy;

import lld.parkinglot.enums.ParkingSpotType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HourlyFeeCalculatingStrategy implements FeeCalculatingStrategy{

    private double hourlyPay(ParkingSpotType parkingSpotType) {
        if (parkingSpotType == ParkingSpotType.BIKE_SPOT) return 20.0;
        else if (parkingSpotType == ParkingSpotType.CAR_SPOT) return 50.0;
        else if (parkingSpotType == ParkingSpotType.TRUCK_SPOT) return 100.0;
        return 0.0;
    }

    @Override
    public double calculateFee(ParkingSpotType parkingSpotType,
                               LocalDateTime entryTime, LocalDateTime exitTime) {
        long totalSecondsParked = ChronoUnit.SECONDS.between(entryTime, exitTime);
        double totalRoundedUpHours = Math.ceil(totalSecondsParked * 1.0 / 3600);

        return totalRoundedUpHours * hourlyPay(parkingSpotType);
    }
}
