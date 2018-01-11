package com.zj.dp.抽象工厂模式.factoryimpl;

import com.zj.dp.抽象工厂模式.factory.RifleFactory;
import com.zj.dp.抽象工厂模式.product.AK47;

/**
 * Created by thinkpad on 2018/1/11.
 */

public class AK47Factory extends RifleFactory {

    @Override
    public void produceRifleGun() {
        new AK47();
    }
}
