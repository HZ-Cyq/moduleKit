package com.ruyuan;

import org.junit.Test;

public class ConstantPoolDemo {
    public static void main(String[] args) {
    }

    @Test
    public void test1() {
        String s0 = "zhigan";
        // 用new创建的字符串不在常量池里
        String s1 = new String("zhigan");
        String s2 = "zhi" + new String("gan");
        System.out.println(s0 == s1); // false
        System.out.println(s0 == s2); // false
        System.out.println(s1 == s2); // false
    }

    @Test
    public void test2() {
        String a = "a1";
        String b = "a" + 1;
        // 在编译期，jvm会将字符串常量的"+"号进行连接。
        System.out.println(a == b); // true
    }

    @Test
    public void test3() {
        String a = "a1";
        String b = "a";
        String c = b + 1;
        // 在编译期，引用的值是无法确定的。
        System.out.println(a == c); // false
    }

    @Test
    public void test4() {
        String a = "a1";
        final String b = "a";
        String c = b + 1;
        // 在编译期，final类型的值可以确定，所以这里返回true
        System.out.println(a == c);
    }

    @Test
    public void test5() {
        String s = "a" + "b" + "c";
        String a = "a";
        String b = "b";
        String c = "c";
        // s1的加操作或变成append.
        String s1 = a + b + c;
        System.out.println(s == s1);
    }
}
