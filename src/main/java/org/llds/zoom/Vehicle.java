package org.llds.zoom;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@Builder
@Setter
@ToString
public class Vehicle extends Entity{
    private String make;
    private String model;
    private int storeId;
    private AtomicReference<VehicleStatus> vehicleStatus;
    public boolean setVehicleStatus(VehicleStatus current, VehicleStatus news){
        return vehicleStatus.compareAndSet(current, news);
    }
}
