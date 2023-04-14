package concurrentset;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteListDemo {
public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("1");
        Thread thread1 = new Thread(() -> System.out.println(
                list.remove("1"))
        );
        Thread thread2 = new Thread(() -> System.out.println(
                list.remove("1"))
    );
        thread1.start();
        thread2.start();
    }
}
