package com.designPattern.decoratorDesignPattern.decorator;

import com.designPattern.decoratorDesignPattern.concept.BasePizza;

public abstract class ToppingsDecorator extends BasePizza {
    public abstract int cost();
}
