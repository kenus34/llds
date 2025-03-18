package org.llds.parking_lot;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class Level {
    int id;
    List<Spot> spots;
}
