package com.zj.dp.装饰者模式.base;

public class CoffeeDecorator extends Coffee {

    protected Coffee mCoffee;

    public CoffeeDecorator(Coffee mCoffee) {
        this.mCoffee = mCoffee;
    }

    @Override
    protected int getPrice() {
        return 0;
    }

    @Override
    protected String getName() {
        return "Coffee";
    }
}
