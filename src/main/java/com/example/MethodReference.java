package com.example;

// method reference way of creating functional interface
interface MyInterface {
    void myMethod();
}

interface MyInterface2 {
    int calculate(int x, int y);
}
public class MethodReference {

    public static void myStaticMethod() {
        System.out.println("Static method");
    }

    public void myInstanceMethod() {
        System.out.println("Instance method");
    }

    public int sumTwoNum(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        MyInterface obj1 = MethodReference::myStaticMethod;
        obj1.myMethod();

        MethodReference methodReference = new MethodReference();
        MyInterface obj2 = methodReference::myInstanceMethod;
        obj2.myMethod();

        MyInterface2 obj3 = methodReference::sumTwoNum;
        System.out.println(obj3.calculate(1,2));
    }
}
