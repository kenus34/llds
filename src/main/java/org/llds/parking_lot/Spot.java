package org.llds.parking_lot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@Builder
@ToString
public class Spot {
    UUID id;
    int levelId;
    AtomicReference<SpotStatus> status;
    SpotType type;
}
