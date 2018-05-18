package com.wylietech.demo.chapter6;

enum Tenor {
  ONE_YEAR(1),
  TWO_YEAR(2),
  THREE_YEAR(3),
  FOUR_YEAR(4),
  FIVE_YEAR(5);

  private final int years;

  private Tenor(int years) {
    this.years = years;
  }

  @Override
  public String toString() {
    return "Tenor{" +
        "years=" + years +
        '}';
  }
}
