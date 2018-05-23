package com.zj.dp.生产者消费者模式.wait_notify;

public class Consumer extends Thread {

    private BufferArea mBufferArea;

    public Consumer(BufferArea bufferArea) {
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