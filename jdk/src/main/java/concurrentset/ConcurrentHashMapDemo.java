package concurrentset;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                hashMap.put(i, i);
            }
            System.out.println("put over");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread thread1 = new Thread(() -> System.out.println(hashMap.get(999)));
        thread1.start();
    }
}
