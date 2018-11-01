package com.zj.java容器.dequeue;

import java.util.ArrayDeque;

public class ArrayDequeueTest {

    public static void main(String[] args) {


        MyArrayDeque arrayDeque = new MyArrayDeque();

        //先入满队元素
        for (int i = 0; i < 15; i++) {
            arrayDeque.addLast("1");
        }

        //观察
        ob(arrayDeque);

        //出队俩个元素
        arrayDeque.poll();
        arrayDeque.poll();

        //观察
        ob(arrayDeque);

        //在入队2个元素
        arrayDeque.add("1");
        arrayDeque.add("1");

        //观察
        ob(arrayDeque);

        //再入队1个元素
        arrayDeque.add("1");

        //观察
        ob(arrayDeque);
    }

    private static void ob(MyArrayDeque arrayDeque) {
        System.out.println("sizeOfArray == " + arrayDeque.sizeOfArray());
        arrayDeque.showHeadAndTail();
    }

}
