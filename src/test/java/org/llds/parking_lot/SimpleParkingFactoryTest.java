package org.llds.parking_lot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleParkingFactoryTest {

    @Test
    void getParkingLot() {
        SimpleParkingFactory simpleParkingFactory = new SimpleParkingFactory();
        List<ParkingConfig> configs = new LinkedList<>();
        configs.add(new ParkingConfig(SpotType.SMALL,5, 0));
        configs.add(new ParkingConfig(SpotType.LARGE,5, 0));
        configs.add(new ParkingConfig(SpotType.MEDIUM,3, 1));
        configs.add(new ParkingConfig(SpotType.LARGE,5, 1));
        simpleParkingFactory.getParkingLot(configs);
    }
}