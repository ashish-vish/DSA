package com.interview.stuff;

public class ConstructorPrintingQuestion {

    ConstructorPrintingQuestion() {
        System.out.println("Constructor");

    }

    ConstructorPrintingQuestion(String s) {
        super();
        System.out.println("Constructor with some argument -> : "+s);

    }
    static {
        System.out.println("Static Block");
    }

    {
        System.out.println("Initialization Block");
    }

    public static void main(String[] args) {
        System.out.println("Main Method");
//        ConstructorPrintingQuestion ashish = new ConstructorPrintingQuestion("Ashish");
    }
}
