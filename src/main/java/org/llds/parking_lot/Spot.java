package org.llds.parking_lot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class Spot {
    int id;
    int levelId;
    @Setter
    SpotStatus status;
    SpotType type;
}
