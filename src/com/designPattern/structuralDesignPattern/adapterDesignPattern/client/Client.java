package com.designPattern.structuralDesignPattern.adapterDesignPattern.client;

import com.designPattern.structuralDesignPattern.adapterDesignPattern.adaptee.WeightMachineForBaby;
import com.designPattern.structuralDesignPattern.adapterDesignPattern.adapter.WeightMachineAdapterImpl;

public class Client {
    public static void main(String[] args) {
        WeightMachineAdapterImpl weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBaby());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
