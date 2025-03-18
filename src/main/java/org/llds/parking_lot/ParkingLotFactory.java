package org.llds.parking_lot;

import java.util.List;

public interface ParkingLotFactory {
    ParkingLot getParkingLot(List<ParkingConfig> configs);
}
