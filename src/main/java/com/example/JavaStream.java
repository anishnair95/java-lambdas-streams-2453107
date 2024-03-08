package com.example;

import java.util.function.BiFunction;

public class JavaStream {


    public static void main(String args[]) {
        testBiFunction();
    }

    public static void testBiFunction() {
        Item item = new Item(10,5.5);
        Item item2 = new Item(100,9.5);
        BiFunction<Integer, Double, Double> discountedPriceCal = (totalPrice, discountPercent) ->
                (totalPrice * (100 - discountPercent)) / 100;
        System.out.println(discountedPriceCal.apply((int) (item.getQuantity() * item.getPrice()), 5D));
        System.out.println(discountedPriceCal.apply((int) (item2.getQuantity() * item2.getPrice()), 10D));
    }
}


class Item {
    int quantity;
    double price;

    public Item() {};
    public Item(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}