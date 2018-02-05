package com.zj.dp.工厂方法模式.普通工厂方法模式;

/**
 * Created by thinkpad on 2018/1/11.
 */

public class M4A1 implements IGun {

    public M4A1() {
        gunType();
        gunName();
    }

    @Override
    public void gunType() {
        System.out.println("类型：步枪");
    }

    @Override
    public void gunName() {
        System.out.println("名称：M4A1");
    }

}
