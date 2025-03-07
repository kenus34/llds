package org.llds.ratelimiter;

import java.util.HashMap;
import java.util.Map;

public class RateLimiterService {

    Map<String, RateLimiter> rateLimiterMap;

    public RateLimiterService(){
        rateLimiterMap = new HashMap<>();
    }

    void add(String appName, RateLimiter rateLimiter){
        rateLimiterMap.put(appName, rateLimiter);
    }

    boolean callAllowed(String appName, String id){
        return rateLimiterMap.containsKey(appName) && rateLimiterMap.get(appName).callAllowed(id);
    }
}
