package org.llds.ratelimiter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@Builder
public class Meta{
    AtomicLong tokenCount;
    Long lastAccessed;


    public Meta() {

    }

    public Meta(AtomicLong tokenCount){
        this.tokenCount = tokenCount;
        lastAccessed = System.currentTimeMillis();
    }
    public Meta(AtomicLong tokenCount, Long lastAccessed){
        this.tokenCount = tokenCount;
        this.lastAccessed = lastAccessed;
    }
}
