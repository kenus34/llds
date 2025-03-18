package org.llds.parking_lot;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class SimpleParkingFactory implements ParkingLotFactory{

    @Override
    public ParkingLot getParkingLot(List<ParkingConfig> configs) {
        Map<Integer, List<Spot>> levels = new HashMap<>();
        for(ParkingConfig config: configs){
            if(!levels.containsKey(config.level)){
                levels.put(config.level, new ArrayList<>());
            }
            for(int i=0;i<config.count;++i){
                levels.get(config.level).add(Spot.builder()
                                .id(UUID.randomUUID())
                                .levelId(config.level)
                                .type(config.spotType)
                                .status(new AtomicReference<>(SpotStatus.AVAILABLE))
                        .build());
            }
        }

        List<Level> nl = new ArrayList<>();
        for(Map.Entry<Integer, List<Spot>> kv: levels.entrySet()){
            nl.add(new Level(kv.getKey(), kv.getValue()));
        }

        ParkingLot parkingLot = new ParkingLot(nl, new ClosestParkingStrategy());

        for(int i=0;i<8;++i){
            try {
                System.out.println(parkingLot.getSpot(SpotType.MEDIUM));
            }catch (Exception e){
                System.out.println("Unavailable");
            }


        }


        return null;
    }
}
