package com.wylietech.demo.chapter4;

import com.wylietech.demo.chapter4a.NonStaticMemberClass;
import org.junit.jupiter.api.Test;

class NonStaticMemberClassTest {

  @Test
  void testMemberClass() {
    NonStaticMemberClass instance = new NonStaticMemberClass("Steve");
    instance.askMemberToWriteName();
  }

}
