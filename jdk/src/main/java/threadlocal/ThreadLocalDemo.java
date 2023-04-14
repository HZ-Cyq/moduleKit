package threadlocal;

/**
 * 参考：
 * https://pdai.tech/md/java/thread/java-thread-x-threadlocal.html
 * http://www.jasongj.com/java/threadlocal/
 *
 * ThreadLocal: 提供了线程局部变量，与普通变量不同的是，每个使用该变量的线程会初始化一个完全独立的实例副本。
 *              ThreadLocal对象通常被private static修饰。
 *              当一个线程结束的时候，它所使用的所有ThreadLocal相对的实例副本都可被回收。
 * 实现原理：Thread类里有一个ThreadLocalMap，这个map存的就是用来存线程局部变量的，key的类型是ThreadLocal,value的类型是Object。
 *          set(T t)方法和get()方法。
 *
 * 应用场景：
 *      1、每个线程需要有自己单独的实例
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> threadId = new ThreadLocal<>();
    public static void main(String[] args) {

        new Thread(() -> {
            threadId.set(1);
            System.out.println("第一个线程打印的值：" + threadId.get());
        }).start();

        new Thread(() -> {
            threadId.set(2);
            System.out.println("第二个线程打印的值：" + threadId.get());
        }).start();
    }
}
