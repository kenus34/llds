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
            if(metaMap.get(id).deque.pollFirst()==null){
                return false;
            }else{
                rateLimiterStrategy.decrease();
                return true;
            }
        }else{
            metaMap.put(id, new Meta());
            return callAllowed(id);
        }
    }
}
