package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class PlanetTest {

  private List<Planet> planets = SolarSystem.getPlanets();
  private PlanetUtils planetUtils = new PlanetUtils();


  @Test
  void testTwoPlanetsStartWithM() {
    List<Planet> actual = planetUtils.getPlanetsBeginningWithM(planets);
    assertThat(actual).hasSize(2);
    assertThat(actual).extracting(Planet::getName)
            .containsExactly("Mercury", "Mars");
  }

  @Test
  void testFourPlanetsHaveRings() {
    List<Planet> actual = planetUtils.getPlanetsWithRings(planets);
    assertThat(actual).hasSize(4);
    assertThat(actual).extracting(Planet::getName)
            .containsExactly("Jupiter", "Saturn", "Uranus", "Neptune");
  }

  @Test
  void testFourPlanetsHaveMoreThanThreeMoons() {
    List<Planet> actual = planetUtils.getPlanetsWithMoreThanThreeMoons(planets);
    assertThat(actual).hasSize(4);
    assertThat(actual).extracting(Planet::getName)
            .containsExactly("Jupiter", "Saturn", "Uranus", "Neptune");
  }

  @Test
  void testThreePlanetsWithDensityGreaterThanFive() {
    List<Planet> actual = planetUtils.getPlanetsWithDensityGreaterThanFive(planets);
    assertThat(actual).hasSize(3);
    assertThat(actual).extracting(Planet::getName)
            .containsExactly("Mercury", "Venus", "Earth");
  }

  @Test
  void consumerTrial() {
    Consumer<String> consumer = (String s) -> {
      List<String> currencies = Arrays.asList(s.split(","));
      System.out.println(currencies);
    };
    consumer.accept("USD,GBP,INR");
    Set<String> currencies = new HashSet<>();
    currencies.add("USD,GBP,EUR");
    currencies.add("HJU,JPY,TJH");
    currencies.forEach(consumer);
  }

  @Test
  void consumerTrial2() {

    List<String> currencies = Arrays.asList("USD","UIJ","EUR","GBP","ABC");
    Consumer<List<String>> consumer = (List<String> c) -> {
        c.sort((a,b) -> a.compareTo(b));
    };

    Consumer<List<String>> consumer2 = (List<String> s) -> {
      System.out.println(s);
    };
    consumer.andThen(consumer2).accept(currencies);
  }


  @Test
  void predicateString() {
    Predicate<String> predicate = (String s) -> s.startsWith("s");
    String str = "surya";
    if (predicate.test(str)) {
      System.out.println("String starts with s");
    }
  }

  @Test
  void predicateInteger() {
    Predicate<Integer> predicate = (Integer i) -> i > 10;
    Integer num = 15;
    if (predicate.test(num)) {
      System.out.println("Number is greater than 10");
    }
  }

  @Test
  void isEqualSimple() {
    Predicate<String> pred = Predicate.isEqual("Educative");
    String test = "educative";

    System.out.println(pred.test(test));
  }
  @Test
  void isEqualDemo() {
    Predicate<String> predicate = Predicate.isEqual("ENABLED");
    List<String> currencyCodes = Arrays.asList("USD", "EUR", "JPY");
    Map<String, String> statusMap = new HashMap<>();
    statusMap.put("USD", "ENABLED");
    statusMap.put("EUR", "DISABLED");
    statusMap.put("JPY", "ENABLED");
    List<String> enabledCodes = currencyCodes.stream()
            .filter(c -> predicate.test(statusMap.get(c)))
            .collect(Collectors.toList());
    System.out.println(enabledCodes);
  }

  @Test
  void andPredicateDemo() {
    Predicate<Integer> greaterThan20 = (Integer val) -> val > 10;
    Predicate<Integer> lessThan50 = (Integer val) -> val < 50;
    int age = 45;
    if(greaterThan20.and(lessThan50).test(age)) {
      System.out.println("Candidate is eligible");
    } else {
      System.out.println("Not eligible");
    }
  }
//  public static <T extends Class<?>, R> void setIfNotNull(T val, Function<T, R> extractor) {
//
//    if (val == null) {
//      return;
//    }
//    extractor.apply(val);
//  }
//
//  @Test
//  void consumerProducer() {
//    String name = "Jupiter";
//    Double density = 2.5;
//    Boolean hasRings = null;
//
//    Map<String, Object> dataMap = new HashMap<>();
//    dataMap.put("name", name);
//    dataMap.put("density", density);
//    dataMap.put("hasRings", null);
//
//    Planet planet = new Planet();
//
//    if (dataMap.get("name") != null) {
//      planet.setName((String) dataMap.get("name"));
//    }
//
//    Consumer<Map<String, Object>>
//    setIfNotNull(name, (String s) -> planet::setName);
//
//    System.out.println(planet.getName());
//  }


  @Test
  public void groupingBy() {
    List<Map<String, Object>> records = new ArrayList<>();
    Map<String, Object> object1 = new HashMap<>();
    object1.put("id", "1ilko");
    object1.put("Name", "Sanfrancisco");
    object1.put("qty", 10);

    Map<String, Object> object2 = new HashMap<>();
    object2.put("id", "1ilko");
    object2.put("Name", "Sanfrancisco");
    object2.put("qty", 20);

    Map<String, Object> object3 = new HashMap<>();
    object3.put("id", "2iuso");
    object3.put("Name", "Switzerland");
    object3.put("qty", 30);

    records.add(object1);
    records.add(object2);
    records.add(object3);

    Map<String, List<Map<String, Object>>> grouped = records
                                                    .stream()
                                                    .collect(Collectors.groupingBy(r -> (String) r.get("id")));
    System.out.println(grouped);
  }
}
