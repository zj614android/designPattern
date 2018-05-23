package com.zj.dp.生产者消费者模式.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockQueueBufferArea {

    BlockingQueue<Integer> mProductPoll = new LinkedBlockingQueue(10);

    public void put() {
        try {
            System.out.println(Thread.currentThread().getName() +   "产品池被放入了一个资源");
            mProductPoll.put(1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void get() {
        try {
            System.out.println(Thread.currentThread().getName() +   "产品池被取走了一个资源");
            mProductPoll.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
