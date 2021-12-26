package com.jgw.learn.multiThread.coreLiabary.scheduledExecutorService;

import java.util.concurrent.Callable;

public class MyCallableB implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("CallableB Begin：" + Thread.currentThread().getName() + "：" + System.currentTimeMillis());
        System.out.println("CallableB End：" + Thread.currentThread().getName() + "：" + System.currentTimeMillis());
        return "return B";
    }
}
