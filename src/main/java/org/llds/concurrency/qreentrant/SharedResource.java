package org.llds.concurrency.qreentrant;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition reentrantCondition = reentrantLock.newCondition();
    private Queue<String> queue = new PriorityQueue<>();
    private final int MAX_SIZE=3;
    public void produce(){
        while (true){
            reentrantLock.lock();
            if(queue.size()<MAX_SIZE){
                try{
                    String uuid= UUID.randomUUID().toString();
                    System.out.println("Starting generating string: "+uuid);
                    queue.add(uuid);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }finally {
                    reentrantLock.unlock();
                }
            }else {
                reentrantCondition.signalAll();
                try {
                    reentrantCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void consume(){
        while (true){
            reentrantLock.lock();
            if(queue.size()>0){
                try{
                    System.out.println("Message consumption staring");
                    Thread.sleep(2000);
                    while (!queue.isEmpty()){
                        System.out.println("Consuming message " + queue.poll());
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    reentrantCondition.signalAll();
                    reentrantLock.unlock();
                }
            }else{
                try {
                    System.out.println("Starting wait");
                    reentrantCondition.await();
                    System.out.println("Wait ended");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
