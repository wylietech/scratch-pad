package com.wylietech.demo.chapter4;

import org.junit.jupiter.api.Test;

class PackagePrivateClassTest {

  @Test
  void canTestPackagePrivateClass() {

    //Because the JUnit tests are in the same package they can see package private
    //classes
    PackagePrivateClass instance = new PackagePrivateClass();

    //We can all package private functions
    instance.thisFunctionIsPackagePrivate();

    //But even here we cant call private functions

  }
}
