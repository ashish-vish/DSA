package com.designPattern.creationalDesignPattern.builderDesignPattern;

public class Phone {
    private final String name;
    private final String brand;
    private final boolean is5g;

    private Phone(PhoneBuilder builder) {
        this.name = builder.name;
        this.brand = builder.brand;
        this.is5g = builder.is5g;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", is5g=" + is5g +
                '}';
    }

    static class PhoneBuilder{
        private String name;
        private String brand;
        private boolean is5g;

        public PhoneBuilder setName(String name){
            this.name = name;
            return this;
        }

        public PhoneBuilder setBrand(String brand){
            this.brand = brand;
            return this;
        }

        public PhoneBuilder setIs5g(boolean is5g){
            this.is5g = is5g;
            return this;
        }

        public Phone build(){
            return new Phone(this);
        }
    }
}
