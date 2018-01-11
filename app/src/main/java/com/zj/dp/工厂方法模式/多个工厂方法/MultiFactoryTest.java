package com.zj.dp.工厂方法模式.多个工厂方法;

import com.zj.dp.工厂方法模式.普通工厂模式.IGun;

/**
 * Created by thinkpad on 2018/1/11.
 */

public class MultiFactoryTest {

    public static void main(String [] args){

        System.out.println("设计模式：多个工厂方法模式");
        GunFactory gunFactory = new GunFactory();
        gunFactory.getGunAK47();
        gunFactory.getGunM4A1();
        gunFactory.getGunUZI();
        gunFactory.getGunMP5();

    }
}
