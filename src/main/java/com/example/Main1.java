package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main1 {

    public static void main(String args[]) {

        Integer scores[] = new Integer[]{80, 66, 73, 92, 43};

        Stream<Integer> stream = Arrays.stream(scores);

        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("coffee");
        shoppingList.add("bread");
        shoppingList.add("pineapple");
        shoppingList.add("milk");
        shoppingList.add("pasta");

        Stream<String> shoppingListStream = shoppingList.stream();
        shoppingListStream.sorted()
                .map(item -> item.toUpperCase())
                .filter(item -> item.startsWith("P"))
                .forEach(item -> System.out.println(item));

        //Another way of creating stream using elements using of
        Stream<String> lettersStream = Stream.of("A", "B", "C");

        System.out.println("Creating streams of string: ");
        lettersStream.forEach(letter -> System.out.println(letter));
    }
}
