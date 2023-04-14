package c10_threadpool;

import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池有5种状态
 * 1、RUNNING：
 * 2、SHUTDOWN：
 * 3、STOP：
 * 4、TIDYING：
 * 5、TERMINATE：
 */
public class ThreadPoolStateDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("hello world1");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("hello world2");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        List<Runnable> runnables = executorService.shutdownNow();
        System.out.println(runnables.size());
        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
    }
}
