package com.wylietech.demo.chapter5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

class VarArgsTest {

  @Test
  void canTestVarArgs() {

    List<String> presenters = Arrays.asList("Rod", "Jane", "Freddy");
    List<String> singers = Arrays.asList("Taylor Swift", "Johnny Cash");

    assertEquals(5, countEveryone(presenters, singers));

  }

  //This takes a vararg number of string lists - which silently get hoovered up into an array
  //However, since arrays dont play well with generics we can get problems
  static int countEveryone(List<String>... stringLists) {

    //Dont explicitly mess with the object array that holds the arguments
    //can cause all sorts of mess
    Object[] objects = stringLists;

    int count = 0;
    for (List<String> list : stringLists) {
      count += list.size();
    }

    return count;
  }

}
