package com.jgw.learn.multiThread.lockAndCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyConcurrentList02<T> {

    List<T> foods = new ArrayList<>(10);
    ReentrantLock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public MyConcurrentList02(List<T> foods) {
        this.foods = foods;
    }

    public MyConcurrentList02() {
    }

    public void produce(T element) {
        if (lock.tryLock()) {
            try {

                if (foods.size() == 10){
                    System.out.println(Thread.currentThread().getName() + "：释放锁，等待生产。");
                    notFull.await();
                    System.out.println(Thread.currentThread().getName() + "：获取锁，开始生产。");
                }

                foods.add(element);
                System.out.println(Thread.currentThread().getName() + "：生产了一个元素（" + element.hashCode() + "）。");
                if (foods.size() > 0) notEmpty.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void consume() {
        if (lock.tryLock()) {
            try {

                if (foods.size() == 0) {
                    System.out.println(Thread.currentThread().getName() + "：释放锁，等待可消费的元素。");
                    notEmpty.await();
                    System.out.println(Thread.currentThread().getName() + "：获取锁，开始消费。");
                }
                T element = foods.get(0);
                foods.remove(element);
                System.out.println(Thread.currentThread().getName() + "：消费了一个元素（" + element.hashCode() + "）。");
                if (foods.size() < 10) notFull.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

class Producer02 implements Runnable {

    private MyConcurrentList02<Object> foods;

    public Producer02(MyConcurrentList02<Object> foods) {
        this.foods = foods;
    }

    @Override
    public void run() {
        foods.produce(new Object());
    }
}

class Consumer02 implements Runnable {

    private MyConcurrentList02<Object> foods;

    public Consumer02(MyConcurrentList02<Object> foods) {
        this.foods = foods;
    }

    @Override
    public void run() {
        foods.consume();
    }
}

class Main02 {
    public static void main(String[] args) {

        MyConcurrentList02<Object> myConcurrentList02 = new MyConcurrentList02<>();
        Producer02 producer02 = new Producer02(myConcurrentList02);
        Consumer02 consumer02 = new Consumer02(myConcurrentList02);

        ScheduledThreadPoolExecutor scheduledExecutor = new ScheduledThreadPoolExecutor(10);
//        scheduledExecutor.scheduleAtFixedRate(producer02, 1, 2, TimeUnit.SECONDS);
//        scheduledExecutor.scheduleAtFixedRate(consumer02, 1, 1, TimeUnit.SECONDS);
        scheduledExecutor.scheduleAtFixedRate(producer02, 1, 1, TimeUnit.SECONDS);
        scheduledExecutor.scheduleAtFixedRate(consumer02, 1, 2, TimeUnit.SECONDS);
        try {
            scheduledExecutor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}