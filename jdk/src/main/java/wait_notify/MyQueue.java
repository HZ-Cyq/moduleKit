package wait_notify;
import java.util.LinkedList;

/**
 * 手写一个简易的并发队列
 */
public class MyQueue {
    private static int MAX_SIZE = 1;
    private LinkedList<String> queue = new LinkedList<>();
    public synchronized void offer(String val) {
        while (queue.size() >= MAX_SIZE) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "加入元素:" + val);
        queue.add(val);
        notifyAll();
    }

    public synchronized String poll() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String re = queue.removeFirst();
        System.out.println(Thread.currentThread().getName() + "删除元素:" + re);
        notifyAll();
        return re;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        Thread thread1 = new Thread(() -> myQueue.offer("1"), "t1");
        Thread thread2 = new Thread(() -> myQueue.offer("2"), "t2");
        Thread thread3 = new Thread(() -> myQueue.offer("3"), "t3");
        Thread thread4 = new Thread(() -> myQueue.poll(), "t4");
        Thread thread5 = new Thread(() -> myQueue.poll(), "t5");
        Thread thread6 = new Thread(() -> myQueue.poll(), "t6");
        Thread thread7 = new Thread(() -> myQueue.poll(), "t7");
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
