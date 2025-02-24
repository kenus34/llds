package org.llds.zoom;

import java.util.List;
import java.util.stream.Collectors;

public class StoreService extends CrudService{

    @Override
    public void set(Entity oldEntity, Entity newEntity) {
        Store oldStore = (Store) oldEntity;
        Store newStore = (Store) newEntity;
        oldStore.setName(newStore.getName());
        oldStore.setLocationId(newStore.getLocationId());
    }

    public List<Store> getStoreByLocationId(int locationId){
        return entities.stream().filter(entity -> {
            Store store = (Store)entity;
            if(store.getLocationId()==locationId){
                return true;
            }
            return false;
        }).map(entity -> (Store)entity).collect(Collectors.toList());
    }
}
