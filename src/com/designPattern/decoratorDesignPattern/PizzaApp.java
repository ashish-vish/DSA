package com.designPattern.decoratorDesignPattern;

import com.designPattern.decoratorDesignPattern.concept.BasePizza;
import com.designPattern.decoratorDesignPattern.concept.FarmHousePizza;
import com.designPattern.decoratorDesignPattern.decorator.ExtraCheese;
import com.designPattern.decoratorDesignPattern.decorator.ExtraMushroom;
import com.designPattern.decoratorDesignPattern.decorator.ExtraVeggie;

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
