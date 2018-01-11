package com.zj.dp.抽象工厂模式.factory;

/**
 * Created by thinkpad on 2018/1/11.
 */

public abstract class SniperFactory implements IGunFactory{

    @Override
    public void produceGun() {
        produceSniperGun();
    }

    public abstract void produceSniperGun();

}
