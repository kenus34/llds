package org.llds.zoom;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class CrudService {
    protected ConcurrentLinkedDeque<Entity> entities;
    private AtomicInteger counter;

    public CrudService(){
        entities = new ConcurrentLinkedDeque<>();
        counter = new AtomicInteger(0);
    }

    public void add(Entity entity){
        entity.setId(counter.addAndGet(1));
        entities.addLast(entity);
    }

    public void update(Entity entity){
        Optional<Entity> optionalEntity = entities.stream().filter(e -> e.getId()== entity.getId()).findFirst();
        optionalEntity.ifPresent(value -> set(value, entity));
    }

    public Optional<Entity> getById(int id){
        return entities.stream().filter(x->x.getId()==id).findFirst();
    }

    public abstract void set(Entity oldEntity, Entity newEntity);

    public int size(){
        return counter.get();
    }

    public void listDisc(){
        Set<Integer> s = new HashSet<>();
        for(Entity entity:entities){
            if(s.contains(entity.getId())){
                System.out.println(entity.getId());
            }else{
                s.add(entity.getId());
            }
        }
    }

}
