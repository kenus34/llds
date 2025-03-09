package org.llds.parking_lot;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Spot getSpot(List<Level> lots);
}
