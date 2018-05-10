package com.wylietech.demo.chapter4a;

import com.wylietech.demo.chapter4.*;

public class ClassThree {

  public void testAccessibility() {

    //Class one is not accessible from here
    //PackagePrivateClass one = new PackagePrivateClass();

    //But we can get an implementation of PublicInterface - which is actually a PackagePrivateClass
    PublicInterface one = PublicInterface.create();
    one.printAnotherMessage();

  }
}
