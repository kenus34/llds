package org.llds.parking_lot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class ParkingLot {
    private List<Level> lots;
    private ParkingStrategy parkingStrategy;

    Spot getSpot(SpotType type){
        return parkingStrategy.getSpot(lots, type);
    }
}
