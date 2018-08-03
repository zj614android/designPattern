package com.zj.dp.观察者模式;

import java.util.ArrayList;
import java.util.List;

public class Observerable_A implements Observerable {

    private String strMsg = "通知：xxx";
    List<Observer> observerList = new ArrayList<>();

    @Override
    public void regist(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void notifyMsg() {
        for (int i = 0; i < observerList.size(); i++) {
            Observer observer = observerList.get(i);
            observer.update(strMsg);
        }
    }

    @Override
    public void unRegist(Observer observer) {
        if (null != observerList) {
            observerList.remove(observer);
        }
    }

}
