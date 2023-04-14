package concurrentset;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConcurrentLikedQueueDemo {
    public static void main(String[] args) {
       testPoll();
    }

    public static void testOffer() {
    }

    public static void testPoll() {
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
    }
}
