package org.llds.concurrency.queue_producer_consumer;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public class Resource {
    Queue<String> queue= new ArrayDeque<>();
    int max=10;

    public synchronized void produce() throws InterruptedException {
        while (true){
            if(queue.size()<max){
                String str= UUID.randomUUID().toString();
                System.out.println("Producing message: " + str);
                queue.add(str);
            }else{
                System.out.println("Maximum messages has been produced");
                notifyAll();
                wait();
            }
        }
    }

    public synchronized void consume() throws InterruptedException {
        while (true){
            if(queue.size()==max){
                System.out.println("Consuming messages");
                System.out.println("*****");
                while (!queue.isEmpty()){
                    System.out.println(queue.poll());
                }
                System.out.println("*****");
                notifyAll();
            }else{
                wait();
            }
        }
    }
}
