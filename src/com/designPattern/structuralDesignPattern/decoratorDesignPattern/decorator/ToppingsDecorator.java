package com.designPattern.structuralDesignPattern.decoratorDesignPattern.decorator;

import com.designPattern.structuralDesignPattern.decoratorDesignPattern.concept.BasePizza;

public abstract class ToppingsDecorator extends BasePizza {
    public abstract int cost();
}
