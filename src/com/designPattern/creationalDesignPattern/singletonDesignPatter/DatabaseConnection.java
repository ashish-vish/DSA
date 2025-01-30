package com.designPattern.creationalDesignPattern.singletonDesignPatter;

public class DatabaseConnection {
    private final String databaseUrl;
    private static DatabaseConnection instance;

    private DatabaseConnection (final String databaseUrl){
        this.databaseUrl = databaseUrl;
    }

    public static DatabaseConnection getInstance(final String databaseUrl){
        if (instance == null)
            instance = new DatabaseConnection(databaseUrl);
        return instance;
    }

    public void connect(){
        System.out.println("Connected to url: "+databaseUrl);
    }
}
