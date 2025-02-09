package org.llds.concurrency.producer_consumer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        Thread thread1= new Thread(()-> resource.produce());
        Thread thread2= new Thread(()-> resource.consume());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
