package concurrentset;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        Thread putThread = new Thread(() -> {
            try {
                queue.put("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread takeThread = new Thread(() -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        putThread.start();
        takeThread.start();
    }
}
