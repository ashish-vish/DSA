package com.designPattern.decoratorDesignPattern.decorator;

import com.designPattern.decoratorDesignPattern.concept.BasePizza;

public class ExtraCheese extends ToppingsDecorator{

    private final BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost()+20;
    }
}
