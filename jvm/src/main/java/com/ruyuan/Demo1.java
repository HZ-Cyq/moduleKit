package com.ruyuan;

/**
 * jvm参数
 * -XX:NewSize=5m -XX:MaxNewSize=5m -XX:InitialHeapSize=10m -XX:MaxHeapSize=10m -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10m -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 * -Xloggc:gc.log
 */
public class Demo1 {
    static int k = 1024;
    static int M = 1024 * 1024;
    static int G = 1024 * 1024 * 1024;
    public static void main(String[] args) {
        byte[] array1 = new byte[M];
        array1 = new byte[M];
        array1 = new byte[M];
        array1 = null;
        byte[] array2 = new byte[2 * M];
    }
}
