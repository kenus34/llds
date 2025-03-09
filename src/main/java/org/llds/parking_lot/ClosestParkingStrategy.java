package org.llds.parking_lot;

import java.util.List;
import java.util.Optional;

public class ClosestParkingStrategy implements ParkingStrategy{
    @Override
    public Spot getSpot(List<Level> lots) {
        for(int i=0;i<lots.size();++i){
            Optional<Spot> parkingSpot = lots.get(i).getSpots().stream()
                    .filter(spot -> spot.getStatus()==SpotStatus.AVAILABLE)
                    .findFirst();
            parkingSpot.ifPresent(spot -> spot.status = SpotStatus.AVAILABLE);
            return parkingSpot.get();
        }
        return null;
    }
}
