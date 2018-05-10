package com.wylietech.demo.chapter4;

/**
 * This class cannot be instantiated from another package - its package private
 * However, because it implements a public interface it can be used externally
 */
class PackagePrivateClass implements PublicInterface {

  /**
   * This function is private - it cant even be accessed by tests
   */
  private void thisFunctionIsPrivate() {

  }

  /**
   * This function cannot be called from another package
   */
  void thisFunctionIsPackagePrivate() {
  }



  /**
   * This function is public - but because the class is package-private it doesnt matter
   * No way of getting a handle on the class to execute it
   */
  public void thisFunctionIsPublic() {

  }

  /**
   * Interface methods must be public
   */
  @Override
  public void printAnotherMessage() {
    System.out.println("Hello from PACKAGE PRIVATE CLASS");
  }
}

