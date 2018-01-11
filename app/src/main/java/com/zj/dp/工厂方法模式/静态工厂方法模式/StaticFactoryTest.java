package com.zj.dp.工厂方法模式.静态工厂方法模式;


/**
 * Created by thinkpad on 2018/1/11.
 */

public class StaticFactoryTest {

    public static void main(String [] args){

        System.out.println("设计模式：静态工厂方法模式");
        GunFactory.getGunAK47();
        GunFactory.getGunM4A1();
        GunFactory.getGunUZI();
        GunFactory.getGunMP5();

    }
}
