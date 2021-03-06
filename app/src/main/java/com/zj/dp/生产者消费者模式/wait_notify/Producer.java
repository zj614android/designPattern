package com.zj.dp.生产者消费者模式.wait_notify;

public class Producer extends Thread {

    private BufferArea mBufferArea;
    public Producer(BufferArea bufferArea){
        this.mBufferArea = bufferArea;
        setName("Producer_"+getName());
    }

    @Override
    public void run() {
        //不断地生产资源
        while (true) {
            sleepSomeTime();
            mBufferArea.put();
        }
    }

    private void sleepSomeTime() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

