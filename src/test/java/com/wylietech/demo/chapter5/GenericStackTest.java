package com.wylietech.demo.chapter5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GenericStackTest {

  @Test
  void canUseStackWithStrings() {
    GenericStack<String> stringStack = new GenericStack<>();
    stringStack.push("Fred");
    assertEquals("Fred", stringStack.pop());
  }

  @Test
  void canUseStackWithInts() {
    GenericStack<Integer> intStack = new GenericStack<>();
    intStack.push(new Integer(42));
    assertEquals(new Integer(42), intStack.pop());
  }

  @Test
  void canUseStackWithNumberOrSubclasses() {

    GenericStack<Number> numberStack = new GenericStack<>();
    numberStack.push(new Integer(12));
    numberStack.pop();
  }
}
