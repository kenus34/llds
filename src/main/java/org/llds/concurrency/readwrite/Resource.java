package org.llds.concurrency.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Resource {
    private ReentrantReadWriteLock readWriteLock;
    private ReentrantReadWriteLock.ReadLock readLock;
    private ReentrantReadWriteLock.WriteLock writeLock;
    private int value;
    public Resource(){
        this.readWriteLock = new ReentrantReadWriteLock();
        this.readLock = readWriteLock.readLock();
        this.writeLock = readWriteLock.writeLock();
        this.value=0;
    }

    public void reader(){
        while (true){
            readLock.lock();
            try{
                System.out.println("Current Read Thread: "+ Thread.currentThread()+" value: "+ value);
            }finally {
                readLock.unlock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void consume(){
        while (true){
            writeLock.lock();
            try{
                System.out.println("Current Update Thread: "+ Thread.currentThread()+" updating value to: "+ ++value);
            }finally {
                writeLock.unlock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
