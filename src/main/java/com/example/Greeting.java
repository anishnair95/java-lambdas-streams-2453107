package com.example;

@FunctionalInterface //this makes sure we cannot add more than one method
//A Functional Interface can have only one abstract method
public interface Greeting {

    void sayHello();
//    void sayGoodBye();
}
