package org.llds.concurrency.threadpool;

//Used to gracefully close a threadpool, no new tasks will be accepted.Existing tasks will be completed

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Shutdown {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,4, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new ThreadPool.CustomThreadFactory(), new ThreadPool.CustomRejectionHandler());
        threadPoolExecutor.submit(()->{
           System.out.println("Starting execution");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Completing execution");
        });
        threadPoolExecutor.shutdown();
        boolean state = threadPoolExecutor.awaitTermination(1000,TimeUnit.MILLISECONDS);
        System.out.println(state);
    }
}
