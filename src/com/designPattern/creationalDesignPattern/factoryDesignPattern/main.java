package com.designPattern.creationalDesignPattern.factoryDesignPattern;

public class main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("circle");
        circle.draw();
        Shape square = shapeFactory.getShape("square");
        square.draw();
        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.draw();
    }
}
