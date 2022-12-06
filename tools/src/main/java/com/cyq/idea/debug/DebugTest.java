package com.cyq.idea.debug;

import org.junit.Test;

import java.util.ArrayList;


/**
 * 参考链接：https://www.bilibili.com/video/BV195411h7nE/
 * 1、指定线程的执行顺序(main，只能用main方法，junit方法不好使)
 * 1、在方法里回到方法的调用处（放弃当前栈帧）(test2)
 * 2、修改内存值(test3)
 * 3、到指定的光标(test4)
 */

public class DebugTest {

    public static void main(String[] args) {
        new Thread(() ->
                //对下面这行打断点，选择按线程断
                System.out.println("线程1启动了"),
                "线程1").start();
        new Thread(() ->
                // 同上
                System.out.println("线程2启动了"),
                "线程2").start();
        new Thread(() ->
                // 同上
                System.out.println("线程3启动了"),
                "线程3").start();
        ArrayList arrayList = new ArrayList();
    }

    @Test
    public void test2() {
        System.out.println("开始执行test1");
        // 在method1方法里打断点，执行到断点的时候点Drop Frame
        method1();
        System.out.println("test1执行结束");
    }

    private void method1() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    @Test
    public void test3() {
        System.out.println("开始执行test2");
        for (int i = 0; i < 100; i++) {
            // 执行到这里的时候，选中i，然后选setValue，就可以修改值了。
            System.out.println(i);
        }
        System.out.println("test2执行完毕");
    }

    @Test
    public void test4() {
        System.out.println("开始执行test3");
        method1();
        System.out.println("test3执行完毕");
    }
}
