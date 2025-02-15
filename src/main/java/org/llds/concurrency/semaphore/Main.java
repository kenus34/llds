package org.llds.concurrency.semaphore;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        Thread thread1= new Thread(()->{
            for(int i=0;i<10000;++i){
                resource.consume();
            }
        });
        Thread thread2= new Thread(()->{
            for(int i=0;i<10000;++i){
                resource.consume();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(resource.getValue());
    }
}
