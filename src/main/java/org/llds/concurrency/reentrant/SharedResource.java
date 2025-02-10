package org.llds.concurrency.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private final ReentrantLock reentrantLock = new ReentrantLock();
    volatile boolean isAvailable=false;
    public void produce(){
        while (true){
            if(!isAvailable){
                reentrantLock.lock();
                try {
                    System.out.println("Starting production: "+ System.currentTimeMillis());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    isAvailable = true;
                    System.out.println("Production complete : "+ System.currentTimeMillis());
                }finally {
                    reentrantLock.unlock();
                    System.out.println("Production unlock completed : "+ System.currentTimeMillis());
                }
            }
            //System.out.println("Producing");
        }
    }

    public void consume(){
        while (true){

            if(isAvailable){
                System.out.println(isAvailable);
                reentrantLock.lock();
                try{
                    System.out.println("Starting consumption: "+ System.currentTimeMillis());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    isAvailable=false;
                }finally {
                    reentrantLock.unlock();
                    System.out.println("Consumption unlock completed : "+ System.currentTimeMillis());
                }
            }
            //System.out.println("Consuming");
        }
    }
}
