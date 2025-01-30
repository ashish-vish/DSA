package com.designPattern.structuralDesignPattern.adapterDesignPattern.adapter;

import com.designPattern.structuralDesignPattern.adapterDesignPattern.adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter{

    private final WeightMachine weightMachine;

    public WeightMachineAdapterImpl(final WeightMachine weightMachine){
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg() {
        double weightInPound = weightMachine.getWeight();
        double weightInKg = weightInPound * 0.45;
        return weightInKg;
    }
}
