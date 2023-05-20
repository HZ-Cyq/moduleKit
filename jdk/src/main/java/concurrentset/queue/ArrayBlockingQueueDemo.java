package concurrentset.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(1);
        arrayBlockingQueue.put("1");
        arrayBlockingQueue.put("2");
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue);
        String poll = arrayBlockingQueue.poll(1, TimeUnit.SECONDS);
    }
}
