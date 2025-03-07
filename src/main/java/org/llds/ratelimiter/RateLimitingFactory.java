package org.llds.ratelimiter;

public interface RateLimitingFactory {
    RateLimiterService getRateLimiter(RateLimiterEnum rateLimiterEnum);
}
