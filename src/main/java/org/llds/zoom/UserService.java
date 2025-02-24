package org.llds.zoom;

public class UserService extends CrudService{

    @Override
    public void set(Entity oldEntity, Entity newEntity) {
        User old = (User) oldEntity;
        User newE = (User) newEntity;
        old.setName(newE.getName());
        old.setNumber(newE.getNumber());
        old.setStatus(newE.getStatus());
    }
}
