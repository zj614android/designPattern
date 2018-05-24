package com.zj.多线程.threadpoll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(25);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程：" + Thread.currentThread().getName());
            }
        };


//        //延迟
//        for (int i = 0; i < 5; i++) {
//            scheduledExecutorService.schedule(task, 3, TimeUnit.SECONDS);
//        }

        //定期
        for (int i = 0; i < 5; i++) {
            scheduledExecutorService.scheduleAtFixedRate(task, 3, 3, TimeUnit.SECONDS);
        }

    }
}
