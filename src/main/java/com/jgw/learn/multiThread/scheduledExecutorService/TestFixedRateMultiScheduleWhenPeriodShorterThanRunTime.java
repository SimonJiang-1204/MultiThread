package com.jgw.learn.multiThread.scheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 测试按照固定频率运行方法，且周期时间小于运行时间-单核心线程
 * 测试结论：任务实际按照任务运行时间作为任务执行的间隔时间，即使多线程运行，也是轮流交替运行，不会并发运行。
 *
 */
public class TestFixedRateMultiScheduleWhenPeriodShorterThanRunTime {

    public static void main(String[] args) throws Exception{
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(6);
        System.out.println("Main Begin：" + System.currentTimeMillis());
        scheduledExecutor.scheduleAtFixedRate(new MyRunableA(), 1, 2, TimeUnit.SECONDS);
        System.out.println("Main end：" + System.currentTimeMillis());

    }
}
