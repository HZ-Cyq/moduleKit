package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试tryLock是如何实现的
 * 1、第一个线程先睡1秒，然后尝试获取锁，如果5秒没获取到锁，返回false
 * 2、第二个线程直接获取读写锁，10秒后在将锁释放
 * System.nanoTime()的返回值和当前的时间没有关系，只有在比较两个时间差的时候，这个值才有意义
 */
public class TryLockDemo {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                boolean b = reentrantLock.tryLock(5, TimeUnit.SECONDS);
                System.out.println("线程1获取到了锁" + b);
                if(b) {
                    reentrantLock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            reentrantLock.lock();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        });
        thread1.start();
        thread2.start();
    }
}
