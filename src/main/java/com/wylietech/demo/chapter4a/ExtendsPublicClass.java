package com.wylietech.demo.chapter4a;

import com.wylietech.demo.chapter4.PublicClass;

public class ExtendsPublicClass extends PublicClass {

  void test() {
    //Even though this is a subclass we cant see package-private methods
    //this.packageMethod();

    //However - we can access this
    this.thisCanBeAccessedBySubclassesEverywhere();
  }

}
