package com.wylietech.demo.chapter5;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class GenericArrayExampleTest {

  @Test
  void canUseGenericArray() {

    String[] data = new String[]{"Fred", "Bjorn", "Ageta", "Anita"};
    GenericArrayExample<String> test = new GenericArrayExample<String>(data);


  }
}
