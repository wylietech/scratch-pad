package com.wylietech.demo.chapter5;

import java.util.Arrays;
import java.util.List;

public class GenericStack<E> {

  //This will actually be an array of objects at runtime, but because arrays are
  //co-variant it will work. The cast on the constructor allows us to avoid casting the
  //gets and sets. The compiler cant prove this works, but we know it does, hence the suppression
  private E[] items;

  @SuppressWarnings("unchecked")
  public GenericStack(){
    items = (E[])new Object[10];
  }

  //We don't need to wildcard this - since E is replaced by a real-type that follows the
  //normal rules. So if E is Number, we can supply Integers or Doubles.
  public void push(E item) {
    items[0] = item;
  }

  //We do need to wildcard this - since a List<Number> != List<Double>. In this case we need
  //a wildcard to show that we will allow lists of subtypes
  public void pushAll(List<? extends E> newItems) {
    items[0] = newItems.get(0);
  }


  public void popAll(List<? super E> output) {
    output.addAll(Arrays.asList(items));
  }


  public E pop() {
    return items[0];
  }


}
