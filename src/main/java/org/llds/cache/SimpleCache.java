package org.llds.cache;

import java.util.concurrent.*;

public class SimpleCache<K,V> implements CacheFactory{
    @Override
    public Cache getCache() {
        Cache<K,V> cache = new Cache<K, V>(new ConcurrentHashMap<>(), new FifiEvictor<K>(10));
        SequentialRunExpiry<K,V> kvSequentialRunExpiry = new SequentialRunExpiry<>(cache);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1,
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread daemon = new Thread(r);
                        daemon.setDaemon(true);
                        daemon.setName("ttl-daemon");
                        return daemon;
                    }
                });
        scheduledExecutorService.scheduleAtFixedRate(kvSequentialRunExpiry::expire
                , 0,1, TimeUnit.SECONDS);
        return cache;
    }
}
