package org.llds.concurrency.sync;

public class Resource {
    public synchronized void syncMethod(){
        System.out.println("Producing resource: "+ System.currentTimeMillis());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifyAll();
        System.out.println("Resource production complete: "+ System.currentTimeMillis());
    }
    synchronized public void inSyncMethod(){
        System.out.println("Inside synchronized method consuming: "+ System.currentTimeMillis());

            try{
                Thread.sleep(10000);
            }catch (Exception e){

            }
            System.out.println("Consumption complete: "+ System.currentTimeMillis());

    }
    public void normal(){
        System.out.println("Normal");
    }
}
