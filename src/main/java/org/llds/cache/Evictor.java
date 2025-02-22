package org.llds.cache;

public interface Evictor<K> {
    K push(K k);
}
