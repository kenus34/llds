package org.llds.concurrency.completablefuture;

import java.util.concurrent.*;

public class FirstSimpleFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2 ,5 ,10
                , TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        Future<?> future = threadPoolExecutor.submit(()->{
           System.out.println("Hello world");
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(future.isDone());
        System.out.println(future.get());
    }
}
