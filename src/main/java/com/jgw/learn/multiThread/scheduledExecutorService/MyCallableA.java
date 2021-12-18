package com.jgw.learn.multiThread.scheduledExecutorService;

import java.util.concurrent.Callable;

public class MyCallableA implements Callable<String> {

    private String userName;

    public MyCallableA(String userName) {
        this.userName = userName;
    }

    public MyCallableA() {
    }

    @Override
    public String call() throws Exception {
        System.out.println("CallA Begin：" + Thread.currentThread().getName() + "：" + System.currentTimeMillis());
        Thread.sleep(4000);
        System.out.println("CallA End：" + Thread.currentThread().getName() + "：" + System.currentTimeMillis());
        return "return A";
    }
}
