package com.zj.dp.观察者模式;

public class Test {

    public static void main(String[] args) {
        Observerable observerable = new Observerable_A();
        Observer observer_A = new Observer_A();
        observerable.regist(observer_A);
        observerable.notifyMsg();
    }

}
