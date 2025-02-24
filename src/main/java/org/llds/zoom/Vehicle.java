package org.llds.zoom;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@Setter
@ToString
public class Vehicle extends Entity{
    private String make;
    private String model;
    private int storeId;
    private VehicleStatus vehicleStatus;
}
