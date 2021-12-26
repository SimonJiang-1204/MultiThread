package com.jgw.learn.multiThread.coreLiabary.scheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 测试按照固定间隔时常运行方法
 * 测试结论：任务运行完毕后间隔指定时长后运行
 *
 */
public class TestFixedDelaySchedule {

    public static void main(String[] args) throws Exception{
        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        System.out.println("Main Begin：" + System.currentTimeMillis());
        scheduledExecutor.scheduleWithFixedDelay(new MyRunableA(), 1, 2, TimeUnit.SECONDS);
        System.out.println("Main end：" + System.currentTimeMillis());
    }
}
