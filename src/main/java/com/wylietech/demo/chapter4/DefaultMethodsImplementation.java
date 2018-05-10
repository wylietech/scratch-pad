package com.wylietech.demo.chapter4;

public class DefaultMethodsImplementation implements InterfaceWithDefaultMethods{

  @Override
  public void standardInterfaceMethod() {
    System.out.println("hi from standard method");
  }

  @Override
  public void interfaceWithImplementationTwo() {
    System.out.println("Hello from implementation");
  }
}

