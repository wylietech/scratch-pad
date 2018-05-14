package com.wylietech.demo.chapter6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class EnumTest {

  @Test
  void canUseEnum() {

    List<Tenor> tenors = Arrays.asList(Tenor.FIVE_YEAR, Tenor.ONE_YEAR, Tenor.THREE_YEAR);
    Collections.sort(tenors);

    tenors.forEach(System.out::println);
  }

  @Test
  void canUseEnumSet() {
    Set<Tenor> allTenors = EnumSet.allOf(Tenor.class);
    EnumSet<Tenor> shortTenors = EnumSet.of(Tenor.ONE_YEAR, Tenor.TWO_YEAR, Tenor.THREE_YEAR);
    Set<Tenor> longTenors = EnumSet.complementOf(shortTenors);

    assertEquals(5, allTenors.size());
    assertEquals(3, shortTenors.size());
    assertEquals(2, longTenors.size());
  }

  @Test
  void canUseEnumMap() {
    EnumMap<Tenor, Double> spreads = new EnumMap<>(Tenor.class);
    spreads.put(Tenor.FIVE_YEAR, 12D);
    spreads.put(Tenor.ONE_YEAR, 7D);
    spreads.put(Tenor.THREE_YEAR, 10D);
    spreads.putIfAbsent(Tenor.FOUR_YEAR, 3D);

    spreads.forEach((k,v) -> spreads.compute(k, this::scaleSpread));

    spreads.forEach((k,v) -> System.out.println(k + " " + v));
  }

  double scaleSpread(Tenor tenor, double spread) {
    return spread * 2;
  }


}
