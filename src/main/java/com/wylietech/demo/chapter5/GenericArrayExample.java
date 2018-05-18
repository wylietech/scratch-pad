package com.wylietech.demo.chapter5;

import java.util.Arrays;
import java.util.List;

public class GenericArrayExample<T> {

  //This is valid - we can have an array of type T
  private T[] entries;

  //This is also a valid declaration
  public List<T>[] items;

  public GenericArrayExample() {

    //These won't compile - it's not possible to create arrays because the compiler
    // can't ensure they're always typesafe (arrays are covariant and generics are not)
    //entries = new T[15];
    //items = new List<T>[4];

    //Because arrays are covariant though, an array of Strings is an array of lists
    //This means that at runtime it will be fine, and we can cast at compile time
    //The compiler will give us a warning - it cant prove this is valid - so we would need
    //to @SuppressWarnings("unchecked")
    entries = (T[])new Object[5];

    //Note that this does compile - because a List<String> is actually just a List
    //with some casts, and a List is an Object
    List<String> strings = Arrays.asList("Fred");
    Object object = strings;

  }

  //This will compile just fine - we can be given an array -we just cant make a new one
  //due to the magic of erasure
  public GenericArrayExample(T[] entries) {
    this.entries = entries;
    System.out.println("We have " +entries.length +  " Entries" );
  }
}
