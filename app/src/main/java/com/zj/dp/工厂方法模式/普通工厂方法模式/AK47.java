package com.zj.dp.工厂方法模式.普通工厂方法模式;

/**
 * Created by thinkpad on 2018/1/11.
 */

public class AK47 implements IGun {

    public AK47() {
        gunType();
        gunName();
    }

    @Override
    public void gunType() {
        System.out.println("类型：步枪");
    }

    @Override
    public void gunName() {
        System.out.println("名称：AK47");
    }
}
