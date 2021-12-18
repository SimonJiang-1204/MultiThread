package com.jgw.learn.multiThread.scheduledExecutorService;

import java.util.concurrent.Callable;

public class MyCallableB implements Callable<String> {

    private String userName;

    public MyCallableB(String userName) {
        this.userName = userName;
    }

    public MyCallableB() {
    }

    @Override
    public String call() throws Exception {
        System.out.println("CallB Begin：" + Thread.currentThread().getName() + "：" + System.currentTimeMillis());
        System.out.println("CallB End：" + Thread.currentThread().getName() + "：" + System.currentTimeMillis());
        return "return B";
    }
}
