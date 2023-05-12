package futuretask.completableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 *  使用FutureTask获取另一个线程的结果
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(2);
            return "hello world";
        });
        new Thread(futureTask).start();
        // 在调用get的时候，主线程会阻塞。
        System.out.println(futureTask.get());
        System.out.println("hello world");
    }
}
