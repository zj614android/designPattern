package com.zj.dp.生产者消费者模式.wait_notify;

public class Test {

    public static void main(String[] args) {

        BufferArea bufferArea = new BufferArea();

        Consumer consumer1 = new Consumer(bufferArea);
        Consumer consumer2 = new Consumer(bufferArea);
        Consumer consumer3 = new Consumer(bufferArea);

        Producer producer1 = new Producer(bufferArea);
        Producer producer2 = new Producer(bufferArea);
        Producer producer3 = new Producer(bufferArea);


        consumer1.start();
        consumer2.start();
        consumer3.start();

        producer1.start();
        producer2.start();
        producer3.start();
    }

}
