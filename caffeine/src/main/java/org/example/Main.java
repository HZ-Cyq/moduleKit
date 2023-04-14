package org.example;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

/**
 * maximumSize:最大容量，如果缓存中的数据量超过最大容量，会有一个异步线程来清理缓存，按照指定的清除策略清理多余的缓存
 * maximumWeight:最大权重，存入缓存的每个元素都有一个权重值，当缓存中所有元素权重值超过最大权重值，会触发异步清除。
 * 最大容量和最大权重只能二选一作为缓存空间的限制
 */
public class Main {
    public static void main(String[] args) {
        Caffeine caffeine = Caffeine.newBuilder().initialCapacity(3).maximumSize(4);
        Cache cache = caffeine.build();
        cache.put("aa", 12);
        System.out.println(cache.getIfPresent("aa"));
    }

}