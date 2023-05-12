package futuretask.completableFuture;

import java.util.concurrent.*;


public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(2);
            return "hello world";
        });
        new Thread(futureTask).start();
    }
}
