package com.wylietech.demo.chapter7;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class StreamTest {

  private Stream<Integer> integerStream = Stream.of(1,2,3,4,5,6,7,8,9,10);
  Stream<Integer> doublesStream = Stream.iterate(2, item -> item *2);

  @Test
  void canCreateStream() {


  }

  @Test
  void canFilterAndPrint() {
    integerStream.filter(s -> s < 6)
        .forEach(System.out::println);
  }

  @Test
  void canLimitStream() {
    doublesStream.limit(10)
        .forEach(System.out::println);
  }
}
