package org.llds.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
public class Cache<K,V> {
    @AllArgsConstructor
    @Getter
    class Node{
        private V val;
        @Setter
        private long ttl;
    }

    protected Map<K,Node> map;
    Evictor<K> evictor;
    public void set(K key, V val){
        if(!map.containsKey(key)){
            K delKey = evictor.push(key);
            if(delKey!=null){
                System.out.println("Expiring key " + delKey);
                map.get(delKey).setTtl(System.currentTimeMillis()-1L);
            }
        }
        map.put(key, new Node(val, Long.MAX_VALUE));
    }
    public void set(K key, V val, Long ttl){
        map.put(key, new Node(val, System.currentTimeMillis()+ttl*1000));
    }

    protected void delete(K key){
        map.remove(key);
    }

    public V get(K key){
        if(map.containsKey(key)){
            Node val= map.get(key);
            if(System.currentTimeMillis()<=val.ttl){
                return val.getVal();
            }else{
                delete(key);
            }
        }
        return null;
    }

    public void list(){
        for(Map.Entry<K,Node> es: map.entrySet()){
            System.out.println(es.getKey() + " " + es.getValue().getVal());
        }
    }
    public void parallelList(){
        map.forEach((x,y)->{
            String p = x + " " + y.getVal();
            System.out.println(p);
        });
    }
}
