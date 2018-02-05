package com.zj.dp.工厂方法模式.普通工厂方法模式;

/**
 * Created by thinkpad on 2018/1/11.
 */

public class MP5 implements IGun {


    public MP5() {
        gunType();
        gunName();
    }


    @Override
    public void gunType() {
        System.out.println("类型：冲锋枪");
    }

    @Override
    public void gunName() {
        System.out.println("名称：MP5");
    }

}
