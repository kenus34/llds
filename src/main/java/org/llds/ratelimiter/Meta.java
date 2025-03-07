package org.llds.ratelimiter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
public class Meta{

    Long lastAccessed;
    ConcurrentLinkedDeque<UUID> deque;

    public Meta() {
        this.lastAccessed=0L;
        deque = new ConcurrentLinkedDeque<>();
    }

    public Meta(ConcurrentLinkedDeque<UUID> deque){
        this.deque = deque;
        lastAccessed = System.currentTimeMillis();
    }
    public Meta(ConcurrentLinkedDeque<UUID> deque, Long lastAccessed){
        this.deque = deque;
        this.lastAccessed = lastAccessed;
    }
}
