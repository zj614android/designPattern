package com.zj.多线程.sychronized.死锁;

public class DeadLock {

    //1：2个不同的锁
    //2：任何一方都没法释放对方所需要的锁，因为双方要释放对方所需要的锁的条件就是对方的锁。
    /*
     * A和B
     * A说，我想把我的锁给你，但是没有你的锁，我没法给你
     * 再比如，2扇门，A的门把B关外面，B的门把A关外面
     * */

    public static void main(String[] args) throws InterruptedException {

        final Lock lock1 = new Lock();
        final Lock lock2 = new Lock();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock1) {
                        System.out.println("thread 111 out");
                        synchronized (lock2) {
                            System.out.println("thread 111 in");
                        }
                    }
//                    System.out.println("thread 111 in");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock2) {
                        System.out.println("thread 222 out");
                        synchronized (lock1) {
                            System.out.println("thread 222 in");
                        }
                    }
//                    System.out.println("thread 222 in");
                }

            }
        }).start();

    }


    //锁对象
    static class Lock {

        Lock() {
        }

    }


}
