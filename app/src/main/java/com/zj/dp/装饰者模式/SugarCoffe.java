package com.zj.dp.装饰者模式;

import com.zj.dp.装饰者模式.base.Coffee;
import com.zj.dp.装饰者模式.base.CoffeeDecorator;

public class SugarCoffe extends CoffeeDecorator {

    public SugarCoffe(Coffee mCoffee) {
        super(mCoffee);
    }


    @Override
    protected String getName() {
        return "Sugar "+super.getName();
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 10;
    }
}
