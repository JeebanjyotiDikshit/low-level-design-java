package lld.parkinglot.strategy;

import lld.parkinglot.enums.ParkingSpotType;

import java.time.LocalDateTime;

public interface FeeCalculatingStrategy {
    double calculateFee(ParkingSpotType parkingSpotType,
                        LocalDateTime entryTime, LocalDateTime exitTime);
}
