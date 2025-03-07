package org.llds.ratelimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class RateLimiter {

    RateLimiterStrategy rateLimiterStrategy;
    Map<String, Meta> metaMap;

    public RateLimiter(RateLimiterStrategy rateLimiterStrategy){
        this.rateLimiterStrategy = rateLimiterStrategy;
        this.metaMap = new ConcurrentHashMap<>();
    }

    public boolean callAllowed(String id) {
        if(metaMap.containsKey(id)){
            rateLimiterStrategy.refill(metaMap, id);
            Meta meta = metaMap.get(id);
            Long tc=meta.tokenCount.get();
            if(tc>0L){
                if(meta.getTokenCount().compareAndSet(tc, tc-1)){
                    return true;
                }else{
                    return callAllowed(id);
                }
            }else{
                return false;
            }
        }else{
            metaMap.put(id, Meta.builder().tokenCount(new AtomicLong(10L)).lastAccessed(System.currentTimeMillis()).build());
            return callAllowed(id);
        }
    }
}
