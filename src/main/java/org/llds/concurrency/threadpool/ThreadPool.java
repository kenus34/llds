package org.llds.concurrency.threadpool;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,4, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejectionHandler());
        for(int i=0;i<10;++i){
            int finalI = i;
            threadPoolExecutor.submit(() -> {
                System.out.println("Submitting task: " + finalI);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task: " + finalI + " complete");
            });
        }
        threadPoolExecutor.shutdown();
    }

    static class CustomThreadFactory implements ThreadFactory{
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("cthread");
            return thread;
        }
    }

    static class CustomRejectionHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task rejected");
        }
    }

}
