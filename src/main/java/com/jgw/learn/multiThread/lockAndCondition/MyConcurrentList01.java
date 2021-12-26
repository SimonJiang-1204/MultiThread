package com.jgw.learn.multiThread.lockAndCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MyConcurrentList01<T> {

    List<T> foods = new ArrayList<T>(10);
    ReentrantLock lock = new ReentrantLock();

    public void produce(T element) {
        if (lock.tryLock()) {
            try {

                foods.add(element);
                System.out.println(Thread.currentThread().getName() + "：生产了一个元素（" + element.hashCode() + "）。");

            } finally {
                lock.unlock();
            }
        }
    }

    public void consume() {
        if (lock.tryLock()) {
            try {

                if (foods.size() == 0) {
                    System.out.println(Thread.currentThread().getName() + "：没有可消费的元素。");
                    return;
                }
                T element = foods.get(0);
                foods.remove(element);
                System.out.println(Thread.currentThread().getName() + "：消费了一个元素（" + element.hashCode() + "）。");

            } finally {
                lock.unlock();
            }
        }
    }
}

class Producer01 implements Runnable {

    private MyConcurrentList01<Object> foods;

    public Producer01(MyConcurrentList01<Object> foods) {
        this.foods = foods;
    }

    @Override
    public void run() {
        foods.produce(new Object());
    }
}

class Consumer01 implements Runnable {

    private MyConcurrentList01<Object> foods;

    public Consumer01(MyConcurrentList01<Object> foods) {
        this.foods = foods;
    }

    @Override
    public void run() {
        foods.consume();
    }
}

class Main01 {
    public static void main(String[] args) {

        MyConcurrentList01<Object> myConcurrentList01 = new MyConcurrentList01<>();
        Producer01 producer01 = new Producer01(myConcurrentList01);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(producer01);
            thread.setName("Producer" + i);
            thread.start();
        }

        Consumer01 consumer01 = new Consumer01(myConcurrentList01);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(consumer01);
            thread.setName("Consumer" + i);
            thread.start();
        }

    }
}