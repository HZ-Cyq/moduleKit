package org.example.statsCounter;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;

import java.util.concurrent.TimeUnit;

public class StatusCounterDemo {
    public static void main(String[] args) throws InterruptedException {
        Caffeine caffeine = Caffeine.newBuilder().maximumSize(2).removalListener((Integer key, String value, RemovalCause removalCause) -> {
            System.out.println("被清除的key： " + key + ", 清除的原因：" + removalCause.name());
        });
        Cache cache = caffeine.build();
        cache.put(1, "11");
        cache.put(2, "22");
        cache.put(3, "33");
        cache.put(4, "44");
        cache.put(5, "55");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(cache.getIfPresent(1));
        System.out.println(cache.getIfPresent(2));
        System.out.println(cache.getIfPresent(3));
        System.out.println(cache.getIfPresent(4));
        TimeUnit.SECONDS.sleep(1);
    }
}
