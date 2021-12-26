package com.jgw.learn.multiThread.coreLiabary.scheduledExecutorService;

public class MyRunableB implements Runnable {

    @Override
    public void run() {
        System.out.println("RunableB Begin：" + Thread.currentThread().getName() + "：" + System.currentTimeMillis());
        System.out.println("RunableB End：" + Thread.currentThread().getName() + "：" + System.currentTimeMillis());
    }
}
