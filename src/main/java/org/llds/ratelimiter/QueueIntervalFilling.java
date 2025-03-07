package org.llds.ratelimiter;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class QueueIntervalFilling extends RateLimiterStrategy {
    private AtomicInteger size;
    private Long refillInterval;
    private Long rate;

    public QueueIntervalFilling(Long refillInterval, Long rate){
        this.size= new AtomicInteger(0);
        this.refillInterval=refillInterval;
        this.rate=rate;
    }

    private void fillQueue(Meta meta){
        if(size.incrementAndGet()<=rate){
            meta.deque.add(UUID.randomUUID());
            fillQueue(meta);
        }else{
            size.decrementAndGet();
        }
    }

    @Override
    boolean refill(Map<String, Meta> metaMap, String id) {
        if(System.currentTimeMillis() - metaMap.get(id).lastAccessed>refillInterval*1000L){
            fillQueue(metaMap.get(id));
            metaMap.get(id).setLastAccessed(System.currentTimeMillis());
        }
        return true;
    }

    void decrease(){
        size.decrementAndGet();
    }
}
