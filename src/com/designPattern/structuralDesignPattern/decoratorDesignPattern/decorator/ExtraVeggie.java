package com.designPattern.structuralDesignPattern.decoratorDesignPattern.decorator;

import com.designPattern.structuralDesignPattern.decoratorDesignPattern.concept.BasePizza;

public class ExtraVeggie extends ToppingsDecorator{

    private final BasePizza basePizza;

    public ExtraVeggie(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost()+50;
    }
}
