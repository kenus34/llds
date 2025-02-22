package org.llds.cache;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SequentialRunExpiry<K,V> extends KeyExpiryStrategy<K,V> {

    public SequentialRunExpiry(Cache<K,V> cache) {
        super(cache);
    }

    @Override
    public void expire() {
        List<K> expiredKeys = new LinkedList<>();
        for(Map.Entry<K, Cache<K, V>.Node> entry: cache.map.entrySet()){
            if(System.currentTimeMillis()>entry.getValue().getTtl()){
                expiredKeys.add(entry.getKey());
            }
        }
        for(K key: expiredKeys){
            System.out.println("Delete key: " + key.toString());
            cache.delete(key);
        }
    }
}
