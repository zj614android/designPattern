package com.zj.dp.抽象工厂模式.factoryimpl;

import com.zj.dp.抽象工厂模式.factory.SniperFactory;
import com.zj.dp.抽象工厂模式.product.AWP;

/**
 * Created by thinkpad on 2018/1/11.
 */

public class AWPFactory extends SniperFactory {

    @Override
    public void produceSniperGun() {
        new AWP();
    }

}
