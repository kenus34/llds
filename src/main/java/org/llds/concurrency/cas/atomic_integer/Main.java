package org.llds.concurrency.cas.atomic_integer;

public class Main {
    public static void main(String[] args) {
        Resource res= new Resource();
        Thread th1= new Thread(()->
        {
            for(int i=0;i<10000;++i){
                res.increment();
            }
        });
        Thread th2= new Thread(()->
        {
            for(int i=0;i<10000;++i){
                res.increment();
            }
        });
        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(res.get());
    }
}
