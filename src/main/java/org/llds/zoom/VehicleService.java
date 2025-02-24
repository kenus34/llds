package org.llds.zoom;

public class VehicleService extends CrudService{

    @Override
    public void set(Entity oldEntity, Entity newEntity) {
        Vehicle oldVehicle = (Vehicle) oldEntity;
        Vehicle newVehicle = (Vehicle) newEntity;
        oldVehicle.setMake(newVehicle.getMake());
        oldVehicle.setModel(newVehicle.getModel());
        oldVehicle.setVehicleStatus(newVehicle.getVehicleStatus());
    }
}
