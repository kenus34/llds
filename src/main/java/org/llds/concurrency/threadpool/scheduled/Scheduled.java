package org.llds.concurrency.threadpool.scheduled;

import java.util.concurrent.*;

public class Scheduled {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.schedule(()->{
            System.out.println("Hello world");
        }, 5, TimeUnit.SECONDS);
        ScheduledFuture<Integer> integerCallable =scheduledExecutorService.schedule(()->{
            System.out.println("Hello world callable");
            return 10;
        }, 15, TimeUnit.SECONDS);
        System.out.println(integerCallable.get());
        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println("Hello world fr");
        }, 5,10, TimeUnit.SECONDS);
    }
}
