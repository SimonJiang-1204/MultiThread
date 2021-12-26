package com.jgw.learn.multiThread.coreLiabary.scheduledExecutorService;

import java.util.concurrent.Callable;

public class MyCallableA implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("CallableA Begin：" + Thread.currentThread().getName() + "：" + System.currentTimeMillis());
        Thread.sleep(4000);
        System.out.println("CallableA End：" + Thread.currentThread().getName() + "：" + System.currentTimeMillis());
        return "return A";
    }
}
