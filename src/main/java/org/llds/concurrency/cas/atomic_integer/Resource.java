package org.llds.concurrency.cas.atomic_integer;

import java.util.concurrent.atomic.AtomicInteger;

public class Resource {
    AtomicInteger i = new AtomicInteger(0);

    void increment(){
        i.addAndGet(1);
    }
    int get(){
        return i.get();
    }
}
