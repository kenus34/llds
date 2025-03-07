package org.llds.ratelimiter;


import java.util.Map;

public class IntervalFilling extends RateLimiterStrategy{

    int refillInterval;
    int rate;
    public IntervalFilling(int refillInterval, int rate){
        this.refillInterval=refillInterval;
        this.rate=rate;
    }
    @Override
    public boolean refill(Map<String, Meta> metaMap, String id) {
        Long currentTime = System.currentTimeMillis();
        if(currentTime - metaMap.get(id).lastAccessed>refillInterval*1000L){
            boolean refillSuccess = metaMap.get(id).getTokenCount().compareAndSet(metaMap.get(id).getTokenCount().get(), rate);
            if(refillSuccess){
                metaMap.get(id).setLastAccessed(currentTime);
                return true;
            }else{
                return false;
            }
        }
        return true;
    }
}
