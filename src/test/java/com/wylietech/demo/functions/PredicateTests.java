package com.wylietech.demo.functions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class PredicateTests {

  List<String> data = Arrays.asList("Rod", "Jane", "Freddy");

  /**
   * A predicate is a function that takes a single argument and returns true or false
   * @param arg
   * @return
   */
  boolean predicate(String arg) {
    return true;
  }

  @Test
  void canUsePredicateVariable() {
    Predicate<String> predicateVariable = s -> {
      return s.length() >= 5;
    };

    List<String> filteredData = data.stream().filter(predicateVariable).collect(Collectors.toList
        ());
    assertEquals(1, filteredData.size());
  }

  @Test
  void canUsePredicateFunction() {

    List<String> filteredData =  data.stream().filter(this::predicate).collect(Collectors.toList());
    assertEquals(3, filteredData.size());
  }

  @Test
  void canUseLambdaPredicateFunction() {

    List<String> filteredData =  data.stream().filter(s -> s.contains("o")).collect(Collectors
        .toList());
    assertEquals(1, filteredData.size());
  }

  @Test
  void canUseLambdaPredicateFunctionWithBody() {

    List<String> filteredData =  data.stream().filter(s -> {
      return s.endsWith("y");
    }).collect(Collectors
        .toList());
    assertEquals(1, filteredData.size());
  }

  @Test
  void canUseAnonymousInnerClass() {
    Predicate<String> predicate = new Predicate<String>() {
      @Override
      public boolean test(String s) {
        return s.length() >= 5;
      }
    };

    List<String> filteredData =  data.stream().filter(predicate).collect(Collectors
        .toList());
    assertEquals(1, filteredData.size());
  }

  @Test
  void canUseInlineAnonymousInnerClass() {

    List<String> filteredData =  data.stream().filter(new Predicate<String>() {
      @Override
      public boolean test(String s) {
        return s.length() >= 5;
      }
    }).collect(Collectors
        .toList());
    assertEquals(1, filteredData.size());
  }


}
