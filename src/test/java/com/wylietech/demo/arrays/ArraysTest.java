package com.wylietech.demo.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ArraysTest {

  @Test
  public void canCreateListFromItems() {

    //Returns a special implementation of List that is backed by an array
    //The list cannot be added to
    List<String> items = Arrays.asList("Rod", "Jane", "Freddy");

    //This would throw an UnsupportedOperationException
    //items.add("Steve");

    //However - this IS allowed - we can modify the array
    items.set(0, "Steve");
    items.forEach(System.out::println);
  }

  @Test
  public void canCreateUnmodifyableList() {

    List<String> items = Arrays.asList("Rod", "Jane", "Freddy");
    List<String> unmodifyableItems = Collections.unmodifiableList(items);

    //This would throw an unsupported operation exception
    //unmodifyableItems.set(0, "Steve");
  }

  public void canCloneArray() {
    String[] a1 = new String[] {"Rod", "Jane", "Freddy"};
    String[] a2 = a1.clone();
  }
}
