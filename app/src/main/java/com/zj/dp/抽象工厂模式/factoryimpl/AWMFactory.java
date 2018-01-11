package com.zj.dp.抽象工厂模式.factoryimpl;

import com.zj.dp.抽象工厂模式.factory.RifleFactory;
import com.zj.dp.抽象工厂模式.factory.SniperFactory;
import com.zj.dp.抽象工厂模式.product.AK47;
import com.zj.dp.抽象工厂模式.product.AWM;

/**
 * Created by thinkpad on 2018/1/11.
 */

public class AWMFactory extends SniperFactory {

    @Override
    public void produceSniperGun() {
        new AWM();
    }


}
