package interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("hello world");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(10);
        thread.interrupt();
    }

}
