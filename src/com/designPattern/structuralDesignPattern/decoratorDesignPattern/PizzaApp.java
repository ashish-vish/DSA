package com.designPattern.structuralDesignPattern.decoratorDesignPattern;

import com.designPattern.structuralDesignPattern.decoratorDesignPattern.concept.BasePizza;
import com.designPattern.structuralDesignPattern.decoratorDesignPattern.concept.FarmHousePizza;
import com.designPattern.structuralDesignPattern.decoratorDesignPattern.decorator.ExtraCheese;
import com.designPattern.structuralDesignPattern.decoratorDesignPattern.decorator.ExtraMushroom;
import com.designPattern.structuralDesignPattern.decoratorDesignPattern.decorator.ExtraVeggie;

public class PizzaApp {
    public static void main(String[] args) {
        BasePizza pizza = new ExtraCheese(new FarmHousePizza());
        System.out.println("FarmHouse + ExtraCheese --->"+pizza.cost());
        pizza = new ExtraVeggie(pizza);
        System.out.println("FarmHouse + ExtraCheese + ExtraVeggie --->"+pizza.cost());
        pizza = new ExtraMushroom(pizza);
        System.out.println("FarmHouse + ExtraCheese + ExtraVeggie + ExtraMushroom--->"+pizza.cost());
    }
}
