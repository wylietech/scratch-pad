package com.wylietech.demo.chapter4;

public interface InterfaceWithDefaultMethods {

  //These are effectively public static variables
  int CONSTANT = 5;

  void standardInterfaceMethod();

  //Default methods need to be implemented with the default keyword
  //They appear in all implementations unless overridden
  default void interfaceWithImplementation() {
    System.out.println("Base Implementation");
  }

  default void interfaceWithImplementationTwo() {
    System.out.println("Base ImplementationTwo");
  }

  //This is a good construct for factories
  public static void printMe() {
    System.out.println("This is a public static method on an interface");
  }
}
