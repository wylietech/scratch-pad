package com.wylietech.demo.chapter7;

public class Trade {

  private boolean isBooked;
  private final int tradeId;
  private String counterparty;

  public Trade(boolean isBooked, int tradeId, String counterparty) {
    this.isBooked = isBooked;
    this.tradeId = tradeId;
    this.counterparty = counterparty;
  }

  public boolean isBooked() {
    return isBooked;
  }

  public void setBooked(boolean booked) {
    isBooked = booked;
  }

  public int getTradeId() {
    return tradeId;
  }

  public String getCounterparty() {
    return counterparty;
  }

  @Override
  public String toString() {
    return "Trade{" +
        "isBooked=" + isBooked +
        ", tradeId=" + tradeId +
        ", counterparty='" + counterparty + '\'' +
        '}';
  }
}
