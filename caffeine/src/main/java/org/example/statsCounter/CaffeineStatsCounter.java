package org.example.statsCounter;

import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import com.github.benmanes.caffeine.cache.stats.StatsCounter;
import org.checkerframework.checker.index.qual.NonNegative;

public class CaffeineStatsCounter implements StatsCounter {
    @Override
    public void recordHits(@NonNegative int count) {
        System.out.println("命中次数：" + count);
    }

    @Override
    public void recordMisses(@NonNegative int count) {
        System.out.println("未命中次数：" + count);
    }

    @Override
    public void recordLoadSuccess(@NonNegative long loadTime) {
        System.out.println("加载成功次数:" + loadTime);
    }

    @Override
    public void recordLoadFailure(@NonNegative long loadTime) {
        System.out.println("加载失败次数:" + loadTime);
    }

    @Override
    public void recordEviction(@NonNegative int weight, RemovalCause cause) {
        System.out.println("因为缓存大小限制，执行来一次缓存清理工作, 清除的数据缓存的权重为: " + weight);
    }

    @Override
    public CacheStats snapshot() {
        return null;
    }
}
