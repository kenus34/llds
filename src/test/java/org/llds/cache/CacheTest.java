package org.llds.cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

class CacheTest {

    @Test
    void set() throws InterruptedException {
        Cache<String, String> cache = new Cache<>(new ConcurrentHashMap<>(), new FifoEvictor<>(3));
        cache.set("key", "value");
        cache.set("key1", "value", 1L);
        Thread.sleep(2000);
        Assertions.assertEquals("value", cache.get("key"));
        Assertions.assertNull(cache.get("key1"));
    }

    @Test
    void testSet() throws InterruptedException {
        Cache<String, String> cache = new Cache<>(new ConcurrentHashMap<>(), new FifoEvictor<>(3));
        cache.set("key", "value");
        cache.set("key1", "value", 1L);
        Thread.sleep(2000);
        System.out.println(cache.get("key"));
        System.out.println(cache.get("key1"));
    }

    @Test
    void get() {
    }

    @Test
    void list() {
    }

    @Test
    void parallelList() {
        Cache<String, String> cache = new Cache<>(new ConcurrentHashMap<>(), new FifoEvictor<>(3));
        cache.set("key", "value");
        cache.set("key1", "value", 1L);
        cache.parallelList();
    }
}