package com.jgw.learn.multiThread.scheduledExecutorService;

public class MyRunable implements Runnable {

    private String userName;

    public MyRunable(String userName) {
        this.userName = userName;
    }

    public MyRunable() {
    }

    @Override
    public void run() {
        System.out.println("Begin：" + Thread.currentThread().getName() + "：" + System.currentTimeMillis());
        System.out.println("End：" + Thread.currentThread().getName() + "：" + System.currentTimeMillis());
    }
}
