package atomic;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    private AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
//        atomicInteger.getAndIncrement();
//        LongAdder longAdder = new LongAdder();
//        longAdder.add(10L);
//        ReentrantLock lock = new ReentrantLock();
//        lock.lock();
//        atomicInteger.getAndIncrement();
        int[] array = new int[501];
        for(int i = 1; i <= 500; i ++) {

        }
        String a = "1231";
        a.toCharArray();

    }
}
