package com.zj.dp.生产者消费者模式.wait_notify;


public class BufferArea {

    //当前资源数量的记数值
    private int currNum = 0;

    //资源池中允许存放的资源数目
    private int maxSize = 10;

    /**
     * 从资源池中取走资源
     */
    public synchronized void get() {

        if (currNum > 0) {
            currNum--;
            System.out.println("Cosumer__" + Thread.currentThread().getName() + "消耗一件资源，" + "当前缓冲区有" + currNum + "个");

            //通知生产者生产资源
            notifyAll();
        } else {
            try {

                //如果没有资源，则Cosumer__进入等待状态
                System.out.println("Cosumer__" + Thread.currentThread().getName() + "：当前缓冲区资源不足，进入等待状态");
                wait();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 向缓冲区中添加资源
     */
    public synchronized void put() {
        //若当前缓冲区内的资源计数小于最大size数，才加
        if (currNum < maxSize) {
            currNum++;
            System.out.println(Thread.currentThread().getName() + "生产一件资源，当前资源池有"+ currNum + "个");

            //通知等待的消费者
            notifyAll();
        } else {
            //若当前缓冲区内的资源计数大于最大size数，则等待
            try {
                System.out.println(Thread.currentThread().getName() + "线程进入等待  << 当前缓冲区内的资源计数大于最大size数");
                wait();//生产者进入等待状态，并释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
