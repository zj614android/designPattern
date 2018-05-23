package com.zj.dp.生产者消费者模式.blockingqueue;


public class Consumer extends Thread {

    private BlockQueueBufferArea mBufferArea;

    public Consumer(BlockQueueBufferArea bufferArea) {
        this.mBufferArea = bufferArea;
        setName("Consumer_"+getName());
    }

    @Override
    public void run() {
        //不断的取出资源
        while (true) {
            sleepSomeTime();
            mBufferArea.get();
        }
    }

    private void sleepSomeTime() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}