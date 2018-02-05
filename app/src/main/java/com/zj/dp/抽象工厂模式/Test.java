package com.zj.dp.抽象工厂模式;

import com.zj.dp.抽象工厂模式.factory.IGunFactory;
import com.zj.dp.抽象工厂模式.factoryimpl.AK47Factory;
import com.zj.dp.抽象工厂模式.factoryimpl.AWMFactory;
import com.zj.dp.抽象工厂模式.factoryimpl.AWPFactory;
import com.zj.dp.抽象工厂模式.factoryimpl.MP5Factory;

/**
 * Created by thinkpad on 2018/1/11.
 */

public class Test {
    public static void main(String [] args){

        System.out.println("设计模式：抽象工厂模式");
        IGunFactory igf1 = new AK47Factory();
        igf1.produceGun();
        IGunFactory igf2 = new MP5Factory();
        igf2.produceGun();

        IGunFactory igf3 = new AWMFactory();
        igf3.produceGun();
        IGunFactory igf4 = new AWPFactory();
        igf4.produceGun();
    }

}
