package com.zj.dp.策略模式;

/**
 * 具体策略1  concrete Strategy
 */
public class    FrescoStrategy extends Strategy{


    @Override
    void imgLoad() {
        System.out.println("imgLoad with FrescoStrategy。");
    }

}
