package com.designPattern.structuralDesignPattern.decoratorDesignPattern.decorator;

import com.designPattern.structuralDesignPattern.decoratorDesignPattern.concept.BasePizza;

public class ExtraMushroom extends ToppingsDecorator{

    private final BasePizza basePizza;

    public ExtraMushroom(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost()+30;
    }
}
