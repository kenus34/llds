package org.llds.parking_lot;

import java.util.List;

public interface ParkingStrategy {
    Spot getSpot(List<Level> lots, SpotType type);
}
