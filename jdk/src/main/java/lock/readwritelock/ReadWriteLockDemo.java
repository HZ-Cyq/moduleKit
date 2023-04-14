package lock.readwritelock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Thread thread1 = new Thread(() -> {
            lock.readLock().lock();
            System.out.println("已获取读锁");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.readLock().unlock();
            System.out.println("已释放读锁");
        });

        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("尝试获取写锁");
            lock.writeLock().lock();
            System.out.println("已获取写锁");
           lock.writeLock().unlock();
        });
        thread1.start();
        thread2.start();
    }
}
