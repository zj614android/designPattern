package com.zj.dp.策略模式;

/**
 * 具体策略2  concrete Strategy
 */
public class GlideStrategy extends Strategy{

    @Override
    void imgLoad() {
        System.out.println("imgLoad with GlideStrategy。");
    }

}
