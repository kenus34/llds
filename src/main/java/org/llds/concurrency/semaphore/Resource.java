package org.llds.concurrency.semaphore;

import lombok.Getter;

import java.util.concurrent.Semaphore;

public class Resource {
    private Semaphore semaphore;

    @Getter
    private int value;
    public Resource(){
        semaphore = new Semaphore(1);
        this.value=0;
    }

    public void consume(){
        try {
            semaphore.acquire();
            ++value;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            semaphore.release();
        }
    }
}
