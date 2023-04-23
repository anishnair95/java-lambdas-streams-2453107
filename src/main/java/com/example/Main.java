package com.example;

import java.util.Random;
import java.util.function.IntBinaryOperator;

public class Main {

    public static void main(String args[]) {

        Greeting greeting = new HelloGreeting();

        greeting.sayHello();

        //another shorter way of doing

        Greeting greeting1 = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Say Hello using direct implementation");
            }
        };

        greeting1.sayHello();

        Greeting greeting3 = () -> { System.out.println("Hello World using lamdba"); };

        greeting3.sayHello();


        //Another functional interface

        Calculator calculator = (x, y) -> {
            Random random = new Random();
            int randomNumber = random.nextInt(50); // generate next number between 0 and 50

            return x + y + randomNumber;
        };

        System.out.println(calculator.calculate(1,2));


        //using inbuilt functional interfaces

        IntBinaryOperator calculator2 = (x, y) -> {
            Random random = new Random();
            int randomNumber = random.nextInt(50); // generate next number between 0 and 50

            return x + y + randomNumber;
        };

        System.out.println("Result of java ready-made interface = " + calculator2.applyAsInt(1,2));

    }
}
