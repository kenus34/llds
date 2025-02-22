package org.llds.cache;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class KeyExpiryStrategy<K,V>{
    Cache<K, V> cache;
    public abstract void expire();
}
