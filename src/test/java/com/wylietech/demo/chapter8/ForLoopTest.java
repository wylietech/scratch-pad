package com.wylietech.demo.chapter8;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ForLoopTest {

  @Test
  void canTestLoop() {

    //This nice syntax ensures that n is only resolved once
    for (int i=0, n = exensiveComputation(); i < n; i++) {
      System.out.println(i);
    }

    //and now the normal way, which will call n a lot
    for (int i=0; i< exensiveComputation(); i++) {
      System.out.println(i);
    }
  }

  @Test
  void canTestBoxing() {
    Integer i1 = new Integer(42);
    Integer i2 = new Integer(42);

    //The values are NOT THE SAME
    assertFalse(i1 == i2);

    String s1 = "42";
    String s2 = "42";

    //But some special magic happens for Strings
    assertTrue(s1 == s2);
  }

  private int exensiveComputation() {
    System.out.println("Calling n");
    return 10;
  }
}
