package com.zj.dp.工厂方法模式.多个工厂方法模式;

import com.zj.dp.工厂方法模式.普通工厂方法模式.AK47;
import com.zj.dp.工厂方法模式.普通工厂方法模式.IGun;
import com.zj.dp.工厂方法模式.普通工厂方法模式.M4A1;
import com.zj.dp.工厂方法模式.普通工厂方法模式.MP5;
import com.zj.dp.工厂方法模式.普通工厂方法模式.UZI;

/**
Created by thinkpad on 2018/1/11

设计模式(1)の创建型の工厂方法模式模式（Factory Method）の（普通|简单）工厂模式

理解：
 就拿CS这个游戏来说，枪分为冲锋枪(MP5/UZI/MK5)，步枪（M4a1/AK47/），手枪（MP5/沙漠之鹰），狙击枪（AWP/AWM）
 为了获得这些枪械，我们就需要一个工厂来创建这些枪械。
 这里涉及的2个角色，枪厂（工厂），枪械（产品）

 ps:为了简单起见，这里我就弄最简单的2个种类。步枪，冲锋枪

实施：
 1.抽象产品 IGun.java
 2.实现具体的产品 AK47.java / MP5.java / UZI.java / M4A1.java
 3.建立工厂生产产品 GunFactory.java
 4.建立测试类：Test.java
 */

public class GunFactory {

    public IGun getGunAK47() {
        return new AK47();
    }
    public IGun getGunM4A1() {
        return new M4A1();
    }
    public IGun getGunMP5() {
        return new MP5();
    }
    public IGun getGunUZI() {
        return new UZI();
    }

}
