package org.llds.concurrency.queue_producer_consumer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        Thread thread1= new Thread(()-> {
            try {
                resource.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2= new Thread(()-> {
            try {
                resource.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
