package c10_threadpool;
import java.util.Arrays;
import java.util.concurrent.*;

public class ThreadPoolDemo2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyThreadPool executorService = new MyThreadPool(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        Executors.newFixedThreadPool(1);
        executorService.submit(() -> System.out.println(1 / 0));
        TimeUnit.SECONDS.sleep(1);
        executorService.submit(() -> System.out.println(2 / 1));
        executorService.submit(() -> System.out.println(3 / 1));
    }
}

class MyThreadPool extends ThreadPoolExecutor {

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("执行完成:" + r);
        FutureTask futureTask = (FutureTask) r;
        Object o = null;
        try {
            o = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(o);

        if(t != null) {
            System.out.println(t.getMessage());
            System.out.println(Arrays.toString(t.getStackTrace()));
        }
    }
}

