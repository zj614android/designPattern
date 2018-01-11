package com.zj.dp.工厂方法模式.普通工厂模式;

/**
 * Created by thinkpad on 2018/1/11.
 */

public class StandardFactoryTest {

    public static void main(String [] args){

        System.out.println("设计模式：简单工厂模式");
        GunFactory gunFactory = new GunFactory();

        IGun ak47 = gunFactory.getGun("AK47");
        IGun m4a1 = gunFactory.getGun("M4A1");
        IGun mp5 = gunFactory.getGun("MP5");
        IGun uzi = gunFactory.getGun("UZI");

    }
}
