package com.jgw.learn.multiThread.scheduledExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 测试延迟运行方法Callable-单核心线程
 *
 */
public class TestDelayScheduleCallableSingleThread {

    public static void main(String[] args) throws Exception{
        List<Callable<String>> taskList = new ArrayList<>();
        taskList.add(new MyCallableA());
        taskList.add(new MyCallableB());

        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<String> scheduleFutureA = scheduledExecutor.schedule(taskList.get(0), 1, TimeUnit.SECONDS);
        ScheduledFuture<String> scheduleFutureB = scheduledExecutor.schedule(taskList.get(1), 1, TimeUnit.SECONDS);
        System.out.println("Main Begin：" + System.currentTimeMillis());
        System.out.println("CallA return：" + scheduleFutureA.get());
        System.out.println("CallB return：" + scheduleFutureB.get());
        System.out.println("Main end：" + System.currentTimeMillis());

    }
}
