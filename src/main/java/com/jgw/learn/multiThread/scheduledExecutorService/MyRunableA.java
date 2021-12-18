package com.jgw.learn.multiThread.scheduledExecutorService;

public class MyRunableA implements Runnable {

    @Override
    public void run() {
        System.out.println("RunableA Begin：" + Thread.currentThread().getName() + "：" + System.currentTimeMillis());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("线程被中断了！");
        }
        System.out.println("RunableA End：" + Thread.currentThread().getName() + "：" + System.currentTimeMillis());
    }
}
