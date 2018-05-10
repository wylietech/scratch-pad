package com.wylietech.demo.chapter4;

import org.junit.jupiter.api.Test;

class StaticMemberClassTest {

  @Test
  void testHelper() {
    StaticMemberClassTest.Helper helper = new StaticMemberClassTest.Helper();
    helper.help();
  }

  private static void printPrivateMessage() {
    System.out.println("I am a private function");
  }

  public static class Helper {

    public void help() {
      System.out.println("I am a helper - I can call private functions");
      printPrivateMessage();
    }
  }
}
