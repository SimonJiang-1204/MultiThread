package com.jgw.learn.multiThread.scheduledExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 测试延迟运行方法Runnable-单核心线程
 *
 */
public class TestDelayScheduleRunableSingleThread {

    public static void main(String[] args) throws Exception{
        List<Runnable> taskList = new ArrayList<>();
        taskList.add(new MyRunableA());
        taskList.add(new MyRunableB());

        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        System.out.println("Main Begin：" + System.currentTimeMillis());
        scheduledExecutor.schedule(taskList.get(0), 1, TimeUnit.SECONDS);
        scheduledExecutor.schedule(taskList.get(1), 1, TimeUnit.SECONDS);
        System.out.println("Main end：" + System.currentTimeMillis());

    }
}
