package org.llds.zoom;

import java.util.Collections;
import java.util.List;

public class LocationService extends CrudService{

    @Override
    public void set(Entity oldEntity, Entity newEntity) {
        Location oldLocation = (Location) oldEntity;
        Location newLocation = (Location) newEntity;
        oldLocation.setName(newLocation.getName());
        oldLocation.setTags(newLocation.getTags());
    }

    public List<Location> search(String searchString){
        return Collections.emptyList();
    }
}
