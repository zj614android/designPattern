package com.zj.dp.生产者消费者模式.wait_notify;

public class Cosumer extends Thread {

    private String consumer;
    private Storage storage;

    public Cosumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        consume(consumer);
    }

    public void consume(String consumer) {
        storage.consume(consumer);
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

}