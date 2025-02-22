package org.llds.concurrency.completablefuture;

import java.util.concurrent.*;

public class FourSupplyAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2 ,5 ,10
                , TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        //Then apply will take the result of previous step and execute the new step.
        //This execution is done on the same thread.
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
            return "Task completed";
        },threadPoolExecutor).thenApply(output-> {
            return output +" Successfully";
        });
        //This execution is done on a different thread.
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()->{
            return "Task completed";
        },threadPoolExecutor).thenApplyAsync(output-> {
            return output +" Successfully";
        });
        System.out.println(cf1.get());
    }
}
