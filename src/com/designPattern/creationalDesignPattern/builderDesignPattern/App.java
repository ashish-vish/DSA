package com.designPattern.creationalDesignPattern.builderDesignPattern;

public class App {
    public static void main(String[] args) {
        Phone iphone = new Phone.PhoneBuilder()
                .setBrand("iphone")
                .setName("14")
                .setIs5g(true)
                .build();
        System.out.println(iphone);
    }
}
