package org.example;

import org.quartz.CronExpression;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        // 每天12点执行
        CronExpression cronExpression1 = new CronExpression("0 0 6 * * ?");
        CronExpression cronExpression2 = new CronExpression("0 0 12 * * ?");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse("2023-04-12 11:01:00");
        Date date1 = cronExpression1.getNextValidTimeAfter(date);
        Date date2 = cronExpression2.getNextValidTimeAfter(date);
        System.out.println("date: " + date);
        System.out.println("date1: " + date1);
        System.out.println("date2: " + date2);
    }
}