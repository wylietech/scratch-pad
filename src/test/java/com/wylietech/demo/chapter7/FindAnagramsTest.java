package com.wylietech.demo.chapter7;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class FindAnagramsTest {

  @Test
  void findAnagrams() {

    Stream<String> words = Stream.of("bat", "tab", "fish", "kale", "lake", "laek");

    Anagrams anagrams = new Anagrams();
    anagrams.findAnagrams(words);
  }
}
