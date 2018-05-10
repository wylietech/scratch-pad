package com.wylietech.demo.chapter4;

public class PublicClass {

  //This method can only be accessed within the package (by other classes or subclasses)
  void packageMethod() {

  }

  //This method can be acccessed within the package and by subclasses everywhere
  protected void thisCanBeAccessedBySubclassesEverywhere() {

  }

}
