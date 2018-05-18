package com.wylietech.demo.chapter5;

import org.junit.jupiter.api.Test;

class CovariantArraysTest {

  @Test
  void canCallCovariantArray() {

    //This works because arrays are co-variant - an array of Strings is an array of Objects
    String[] sausages = new String[] {"pork", "leek", "onion"};
    calcObjects(sausages);
  }


  void calcObjects(Object[] data) {
    for (Object o : data) {
      System.out.println(o);
    }

    //This is legal at compile time but will cause a runtime ArrayStoreException
    //data[0] = new Integer(34);
  }
}
