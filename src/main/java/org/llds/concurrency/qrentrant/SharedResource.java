package org.llds.concurrency.qrentrant;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    private Queue<String> queue = new PriorityQueue<>();
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition emptyCondition = reentrantLock.newCondition();
    private final Condition fullCondition = reentrantLock.newCondition();
    private final int MAX_SIZE=3;
    public void produce(){
        while (true){
            reentrantLock.lock();
            try{
                while(queue.size()==MAX_SIZE){
                    try {
                        fullCondition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Staring message production");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                String uuid = UUID.randomUUID().toString();
                queue.add(uuid);
                System.out.println("Message production complete");
                emptyCondition.signalAll();
            }finally {
                reentrantLock.unlock();
            }
        }
    }

    public void consume(){
        while (true){
            reentrantLock.lock();
            try {
                while(queue.isEmpty()){
                    try {
                        emptyCondition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Starting message consumption");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Message consumption complete: " + queue.poll());
                fullCondition.signalAll();
            }finally {
                reentrantLock.unlock();
            }
        }
    }
}
