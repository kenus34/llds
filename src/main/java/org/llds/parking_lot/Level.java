package org.llds.parking_lot;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Level {
    int id;
    List<Spot> spots;
}
