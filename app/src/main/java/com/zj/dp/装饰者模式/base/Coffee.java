package com.zj.dp.装饰者模式.base;

public abstract class Coffee {

    abstract int getPrice();

    abstract String getName();

    @Override
    public String toString() {
        return getName() + " ___ price ：" + getPrice();
    }
}
