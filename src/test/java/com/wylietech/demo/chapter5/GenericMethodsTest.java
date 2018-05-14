package com.wylietech.demo.chapter5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import org.junit.jupiter.api.Test;

class GenericMethodsTest {

  @Test
  void canCountItems() {
    List<String> actors = Arrays.asList("Rod" , "Jane", "Freddy");
    assertEquals(3, countItems(actors));

    List<Integer> numbers= Arrays.asList(1,2,3,4,5);
    assertEquals(5, countItems(numbers));
  }

  @Test
  void canCombineSets() {
    Set<Integer> setOne = new HashSet<>();
    setOne.add(1);
    setOne.add(2);

    Set<Integer> setTwo = new HashSet<>();
    setTwo.add(3);
    setTwo.add(4);

    Set<Integer> results = union(setOne, setTwo);
    assertEquals(4, results.size());
  }

  @Test
  void canCombineSetsOfDifferentSubtypes() {
    Set<Integer> setOne = new HashSet<>();
    setOne.add(1);
    setOne.add(2);

    Set<Double> setTwo = new HashSet<>();
    setTwo.add(3.45);
    setTwo.add(4.34);

    Set<Number> results = union(setOne, setTwo);
    assertEquals(4, results.size());
  }

  public static <E> int countItems(List<E> items) {
    return items.size();
  }

  //This is a more useful example - takes 2 parameterized types and returns their union
  public static <E> Set<E> union(Set<? extends E> setOne, Set<? extends E> setTwo) {
    HashSet<E> result = new HashSet<>(setOne);
    result.addAll(setTwo);

    return result;
  }
}
