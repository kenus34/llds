package org.llds.ratelimiter;


public class Main {

    public static void abc(RateLimiterService rateLimiterService, String t2){
        for(int i=0;i<20;++i){
            if(rateLimiterService.callAllowed("emerald", "123")){
                System.out.println("Call going: " + t2 + " " + i);
            }else{
                System.out.println("Call failed"+ t2 + " " + i);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(new QueueIntervalFilling(1L,10L));
        RateLimiterService rateLimiterService = new RateLimiterService();
        rateLimiterService.add("emerald", rateLimiter);
        Thread thread1 = new Thread(() -> abc(rateLimiterService,"t1"));
        Thread thread2 = new Thread(() -> abc(rateLimiterService,"t2"));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}