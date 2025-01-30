package com.designPattern.creationalDesignPattern.singletonDesignPatter;

public class application {
    public static void main(String[] args) {
        DatabaseConnection instance = DatabaseConnection.getInstance("jdbc:mysql://localhost:3306/mydb");
        instance.connect();
    }
}
