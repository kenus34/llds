package org.llds.concurrency.producer_consumer;

public class Resource {
    boolean resource = false;
    public synchronized void produce(){
        while (true){
            if(!resource){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Producing resource: " +System.currentTimeMillis());
                resource=true;
                notifyAll();
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void consume(){
        while (true){
            if(resource){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Consuming resource: " +System.currentTimeMillis());
                resource=false;
                notifyAll();
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
