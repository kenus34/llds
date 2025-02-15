package org.llds.concurrency.cas.atomic_referance;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> stringLinkedList = new LinkedList<>();
        Thread t1= new Thread(()->{
           for(int i=0;i<10000;++i){
               stringLinkedList.add(UUID.randomUUID().toString());
           }
        });
        Thread t2= new Thread(()->{
            for(int i=0;i<10000;++i){
                stringLinkedList.add(UUID.randomUUID().toString());
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(stringLinkedList.size());
        t1= new Thread(()->{
            for(int i=0;i<10000;++i){
                System.out.println(stringLinkedList.pull());
            }
        });
        t2= new Thread(()->{
            for(int i=0;i<10000;++i){
                System.out.println(stringLinkedList.pull());
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
