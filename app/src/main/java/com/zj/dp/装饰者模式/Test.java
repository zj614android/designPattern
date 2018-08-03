package com.zj.dp.装饰者模式;

import com.zj.dp.装饰者模式.base.SimpleCoffe;

public class Test {

    public static void main(String[] args) {
        MilkCoffe milkCoffe = new MilkCoffe(new SimpleCoffe());
        SugarCoffe sugarCoffe = new SugarCoffe(new SimpleCoffe());
        System.out.println(milkCoffe);
        System.out.println(sugarCoffe);
    }
}
