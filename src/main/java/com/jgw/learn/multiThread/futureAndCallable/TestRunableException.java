package com.jgw.learn.multiThread.futureAndCallable;

import java.util.concurrent.*;

/**
 * 1.execute方法只能执行Runable
 * 2.execute方法会抛出异常，submit方法不会
 * 3.FutureTask.get()方法会使异常抛出
 *
 */
public class TestRunableException {

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            executorService.execute(new MyRunable());
        } catch (Exception e) {
            // 这个地方永远不会catch到异常
            System.out.println("Catched Exception");
        }


        executorService.submit(new MyRunable());
        executorService.submit(new MyCallable());

        // lamda表达式实现执行Runable，Callable
        executorService.submit(() -> System.out.println("run MyRunable!"));
        Future<String> futureTask = executorService.submit(() -> {
            System.out.println("run MyRunable!");
            Integer.parseInt("a");
            return "run MyRunable";
        });

        // get方法调用时才会抛出异常。
        try {
            System.out.println("main return : " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("Catched ExecutionException");
        }
    }
}

class MyRunable implements Runnable {

    @Override
    public void run() {
        Integer.parseInt("a");
        System.out.println("run MyRunable!");
    }
}


class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Integer.parseInt("a");
        System.out.println("run MyCallable!");
        return "a";
    }
}
