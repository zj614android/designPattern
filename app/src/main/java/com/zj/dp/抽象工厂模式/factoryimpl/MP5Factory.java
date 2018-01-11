package com.zj.dp.抽象工厂模式.factoryimpl;

import com.zj.dp.抽象工厂模式.factory.SubmachineFactory;
import com.zj.dp.抽象工厂模式.product.MP5;

/**
 * Created by thinkpad on 2018/1/11.
 */

public class MP5Factory extends SubmachineFactory {

    @Override
    public void produceSubmachineGun() {
        new MP5();
    }
}
