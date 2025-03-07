package org.llds.ratelimiter;

import java.util.Map;

public abstract class RateLimiterStrategy {

    abstract boolean refill(Map<String, Meta> metaMap, String id);
    abstract void decrease();
}
