package com.wylietech.demo.chapter4;

import com.wylietech.demo.chapter4a.ClassThree;
import org.junit.jupiter.api.Test;

class AccessibilityTest {

  @Test
  void canTestAccessibility() {
    ClassThree three = new ClassThree();
    three.testAccessibility();

  }
}
