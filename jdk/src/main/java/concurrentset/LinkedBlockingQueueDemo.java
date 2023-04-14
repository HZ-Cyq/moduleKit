package concurrentset;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueDemo {

    public static void main(String[] args) {
        testOffer();
    }

    public static void testOffer() {
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(2);
        Thread thread1 = new Thread(() -> {
            try {
                linkedBlockingQueue.put("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                linkedBlockingQueue.put("2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                linkedBlockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread4 = new Thread(() -> {
            try {
                linkedBlockingQueue.put("4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread5 = new Thread(() -> {
            try {
                linkedBlockingQueue.put("5");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread6 = new Thread(() -> {
            try {
                System.out.println(linkedBlockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        System.out.println(linkedBlockingQueue);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("挪出一个元素");
        thread6.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(linkedBlockingQueue);
    }
}
