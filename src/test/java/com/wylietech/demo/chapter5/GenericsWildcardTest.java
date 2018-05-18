package com.wylietech.demo.chapter5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class GenericsWildcardTest {

  @Test
  void canCallUnboundedWildcardFunction() {

    List<String> data = Arrays.asList("Fred", "John", "Steve");
    assertEquals(3, listCounter(data));

    Number number;
  }

  @Test
  void canCallBoundedWildcardFunction() {
    List<Number> numbers = new ArrayList<>();
    numbers.add(new Double(43.23));
    numbers.add(new Integer(32));
    numbers.add(new Float(12.34545));
    numbers.add(new BigDecimal( 12345.3435634232));

    numberPrinter(numbers);
  }

  @Test
  void canCallBoundedWildcardFunctionWithSubtype() {
    List<Integer> integers = Arrays.asList(1,2,3,4,5,6);
    numberPrinter(integers);
  }

  int listCounter(List<?> data) {
    return data.size();
  }

  void numberPrinter(List<? extends Number> numbers) {
    for (Number number: numbers) {
      System.out.println(number.intValue());
    }

    //Note that you cannot add to a wildcard array
    //numbers.add(new BigDecimal(34)); Doesnt compile

    //Number number = new Integer(32);
    //numbers.add(number); Neither does this
  }
}
