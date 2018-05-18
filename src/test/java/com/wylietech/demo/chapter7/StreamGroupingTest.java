package com.wylietech.demo.chapter7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StreamGroupingTest {

  private List<Trade> trades = new ArrayList<>();

  public StreamGroupingTest() {

    trades.add(new Trade(1, "JPMorgan", 50000));
    trades.add(new Trade(2, "UBS", 100000));
    trades.add(new Trade(3, "JPMorgan", 750000));
  }

  @Test
  void canGroupTrades() {

    Map<String, List<Trade>> groupedTrades = trades.stream()
        .collect(Collectors.groupingBy(t -> t.getCounterparty()));

    assertEquals(2, groupedTrades.size());
    List<Trade> jpMorganTrades = groupedTrades.get("JPMorgan");
    assertEquals(2, jpMorganTrades.size());

  }

  @Test
  void canPriceTrades() {

    TradePricer pricer = new TradePricer();

    List<Double> prices = trades.stream()
        .map(pricer::price)
        .collect(Collectors.toList());

    assertEquals(100000, prices.get(0).doubleValue());
  }

  private static class Trade {

    private int id;
    private String counterparty;
    private double notional;

    public Trade(int id, String counterparty, double notional) {
      this.id = id;
      this.counterparty = counterparty;
      this.notional = notional;
    }

    public int getId() {
      return id;
    }

    public String getCounterparty() {
      return counterparty;
    }

    public double getNotional() {
      return notional;
    }

    @Override
    public String toString() {
      return "Trade{" +
          "id=" + id +
          ", counterparty='" + counterparty + '\'' +
          ", notional=" + notional +
          '}';
    }
  }

  private static final class TradePricer {

    //If we declare that this method throws a checked exception
    //then we cant use it in a stream
    public double price(Trade trade) {
      return trade.getNotional() * 2;
    }
  }

}
