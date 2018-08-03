package com.zj.dp.观察者模式;

/**
 * 被观察者，通知者
 */
public interface Observerable {


    //1.订阅，加入观察者序列内
    void regist(Observer observer);

    //2.被观察者发送通知
    void notifyMsg();

    //3.取消注册
    void unRegist(Observer observer);


}
