package org.llds.cache;

import lombok.AllArgsConstructor;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class FifiEvictor<K> implements Evictor<K>{
    ConcurrentLinkedDeque<K> concurrentLinkedDeque;
    final private int maxSize;
    private AtomicInteger count;

    public FifiEvictor(int size){
        concurrentLinkedDeque = new ConcurrentLinkedDeque<K>();
        this.maxSize=size;
        this.count = new AtomicInteger(0);
    }

    @Override
    public K push(K k) {

        concurrentLinkedDeque.addLast(k);
        count.incrementAndGet();

        if(count.get()>maxSize){
            K key = concurrentLinkedDeque.pollFirst();
            count.decrementAndGet();
            return key;
        }
        return null;
    }
}
