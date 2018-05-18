package com.wylietech.demo.chapter7;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TradeTest {

  private List<Trade> tradeList;
  private Random random = new Random();

  private UnaryOperator<Trade> tradeBooker = t -> {
    t.setBooked(true);
    return t;
  };

  private Consumer<Trade> tradeLambdaPrinter = t -> System.out.println(t);
  private Consumer<Trade> tradeFunctionReferencePrinter = System.out::println;


  private Predicate<Trade> isBookedLambda = t -> t.isBooked();
  private Predicate<Trade> isBookedFunction = Trade::isBooked;


  private Function<Trade, BigDecimal> tradePricer = t -> new BigDecimal(17);

  @BeforeEach
  void setup() {
    tradeList = new ArrayList<Trade>();
    tradeList.add(new Trade(true, 12, "JPMorgan"));
    tradeList.add(new Trade(true, 23, "UBS"));
    tradeList.add(new Trade(false, 96, "JPMorgan"));

  }

  @Test
  void testConsumer() {
    tradeList.forEach(tradeLambdaPrinter);
    tradeList.forEach(tradeFunctionReferencePrinter);
  }

  @Test
  void testFilter() {
    tradeList.stream()
        .filter(Trade::isBooked)
        .forEach(System.out::println);
  }

  @Test
  void testToList() {
    List<Trade> bookedTrades = tradeList.stream()
        .filter(Trade::isBooked)
        .collect(toList());

    assertEquals(2, bookedTrades.size());
  }

  @Test
  void testToMap() {
    Map<Integer, Trade> tradeMap = tradeList.stream()
        .collect(toMap(Trade::getTradeId, t -> t));

    assertEquals(3, tradeMap.size());
  }
}
