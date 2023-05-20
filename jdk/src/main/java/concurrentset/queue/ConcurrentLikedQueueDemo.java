package concurrentset.queue;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class ConcurrentLikedQueueDemo {
    public static void main(String[] args) {
       testPoll();
    }

    public static void testOffer() {
    }

    public static void testPoll() {
        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                concurrentLinkedQueue.add(i);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Integer val;
            while ((val = concurrentLinkedQueue.poll())!= null) {
                System.out.println(val);
            }
        });
        thread1.start();
        thread2.start();
    }
}
