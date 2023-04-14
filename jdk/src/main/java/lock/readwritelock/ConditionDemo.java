package lock.readwritelock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    static ReentrantLock lock = new ReentrantLock();

    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("第一个线程获取锁,开始进入阻塞状态");
                condition.await();
                System.out.println("第一个线程被唤醒");
                lock.unlock();
                System.out.println("第一个线程释放锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程一").start();

        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("第二个线程获取锁,开始进入阻塞状态");
                condition.await();
                System.out.println("第二个线程被唤醒");
                lock.unlock();
                System.out.println("第二个线程释放锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程二").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("第三个线程尝试获取锁");
            lock.lock();
            System.out.println("第三个线程获取锁, 第二个线程开始唤醒其他线程");
            condition.signalAll();
            System.out.println("第三个线程唤醒了其他线程");
            lock.unlock();
            System.out.println("第三个线程释放了锁");
        }, "线程三").start();
    }
}
