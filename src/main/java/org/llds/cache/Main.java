package org.llds.cache;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Cache cache = new SimpleCache<String, String>().getCache();
        for(int i=0;i<100;++i){
            cache.set("key"+i,"value");
        }
        Thread.sleep(2000);
        System.out.println(cache.get("key"));
    }
}
