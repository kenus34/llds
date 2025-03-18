package org.llds.parking_lot;

import java.util.List;
import java.util.Optional;

public class ClosestParkingStrategy implements ParkingStrategy{
    @Override
    public Spot getSpot(List<Level> lots, SpotType type) {
        for(int i=0;i<lots.size();++i){
            Optional<Spot> parkingSpot = lots.get(i).getSpots().stream()
                    .filter(spot -> spot.getStatus().get()==SpotStatus.AVAILABLE&&spot.getType()==type)
                    .findFirst();
            if(parkingSpot.isPresent()){
                boolean success = parkingSpot.get().status.compareAndSet(SpotStatus.AVAILABLE,SpotStatus.UNAVAILABLE);
                if(!success){
                    return getSpot(lots, type);
                }

                return parkingSpot.get();
            }
        }
        throw new RuntimeException("Spot unavailable");
    }
}
