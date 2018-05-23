package com.zj.多线程.sychronized.对象锁;

public class ObjLock2 {


    private static TicketTask ticketTask;

    public static void main(String[] args) {

        ticketTask = new TicketTask(25);

        Thread Threadwindow01 = new Thread(ticketTask, "窗口01");
        Thread Threadwindow02 = new Thread(ticketTask, "窗口02");
        Thread Threadwindow03 = new Thread(ticketTask, "窗口03");
        Threadwindow01.start();
        Threadwindow02.start();
        Threadwindow03.start();

    }




    public static class TicketTask implements Runnable {

        private int num;//票数量

        public TicketTask(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            while (num > 0) {
                wait200mm();
                ticket();
            }
        }

        private synchronized void ticket() {
            //输出当前窗口号以及出票序列号
            System.out.println(Thread.currentThread().getName() + "售出票序列号：" + num--);
        }

    }

    private static void wait200mm() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
