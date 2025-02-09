package org.llds.concurrency.sync;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        Thread thread1= new Thread(()-> resource.syncMethod());
        Thread thread3= new Thread(()-> resource.syncMethod());
        Thread thread2= new Thread(()-> resource.inSyncMethod());
        thread1.start();
        thread2.start();
        thread3.start();
        resource.normal();
        thread1.join();
        thread2.join();
        thread3.join();
    }
}
