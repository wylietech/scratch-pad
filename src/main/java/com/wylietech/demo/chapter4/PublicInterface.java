package com.wylietech.demo.chapter4;

/**
 * This interface is public - it can be implemented anywhere
 */
public interface PublicInterface {

  //Interface methods can only be public - no other declaration is possible
  void printAnotherMessage();

  static PublicInterface create() {
    return new PackagePrivateClass();
  }
}
