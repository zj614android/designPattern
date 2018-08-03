package com.zj.dp.观察者模式;

public class Observer_A implements Observer {

    @Override
    public void update(String msg) {
        System.out.println(msg);
    }

}
