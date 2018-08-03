package com.zj.dp.装饰者模式;

import com.zj.dp.装饰者模式.base.Coffee;
import com.zj.dp.装饰者模式.base.CoffeeDecorator;

public class MilkCoffe extends CoffeeDecorator {


    public MilkCoffe(Coffee mCoffee) {
        super(mCoffee);
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 20;
    }

    /**
     * @return
     */
    @Override
    protected String getName() {
        return "Milk " + super.getName();
    }
}
