package org.llds.parking_lot;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ParkingLot {
    List<Level> lots;
    ParkingStrategy parkingStrategy;
}
