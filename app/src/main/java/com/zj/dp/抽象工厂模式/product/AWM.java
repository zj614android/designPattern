package com.zj.dp.抽象工厂模式.product;

/**
 * Created by thinkpad on 2018/1/11.
 */

public class AWM implements IGun {

    public AWM() {
        gunType();
        gunName();
    }

    @Override
    public void gunType() {
        System.out.println("类型：狙击枪");
    }

    @Override
    public void gunName() {
        System.out.println("名称：AWM");
    }
}
