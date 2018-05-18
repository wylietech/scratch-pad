package com.wylietech.demo.chapter7;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrams {

  public void findAnagrams(Stream<String> words) {

    words.collect(Collectors.groupingBy(this::alphabetize))
        .values()
        .stream()
        .filter(group -> group.size() > 1)
        .forEach(g -> System.out.println(g.size() + ":" + g));

  }

  private String alphabetize(String str) {
    char[] c = str.toCharArray();
    Arrays.sort(c);
    return new String(c);
  }
}
