package com.ruyuan;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo2 {
    public static void main(String[] args) {
        List<Data> datas = new ArrayList<Data>();
        for (int i = 0; i < 10000; i++) {
            datas.add(new Data());
        }
        try {
            TimeUnit.SECONDS.sleep(3600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class Data{

    }
}
