package org.llds.concurrency.completablefuture;

import java.util.concurrent.*;
/*
* A standard Future in Java only allows you to:

Check if the computation is complete (isDone()).
Block and wait for the computation to finish (get()).
Cancel the computation (cancel()).
* While that covers the basics, it often forces you into
* blocking your thread by calling get(). In contrast, CompletableFuture
*  offers a more comprehensive API for asynchronous programming. It
* allows you to register callbacks that get triggered automatically
* when the asynchronous computation finishes—removing or reducing
* the need for explicitly blocking calls.
*
* One of the big advantages of CompletableFuture is that you can chain multiple
* stages of computation in a very readable way. This is extremely useful for scenarios where:

You retrieve some data asynchronously.
You then transform that data.
You maybe transform it again.
And eventually consume the final result.
* */
public class ThirdFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2 ,5 ,10
                , TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            return "Task completed";
        },threadPoolExecutor);
        System.out.println(completableFuture.get());
    }
}
