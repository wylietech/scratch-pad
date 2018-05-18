package com.wylietech.demo.chapter8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.wylietech.demo.chapter7.Trade;
import java.util.Optional;
import java.util.OptionalInt;
import org.junit.jupiter.api.Test;

class OptionalTest {

  @Test
  void canUseOptionalWithString() {

    Optional<String> answer = Optional.empty();
    Optional<String> realAnswer = Optional.of("Answer");

    String a1 = answer.orElse("No answer was found");
    String a2 = realAnswer.get();

    assertEquals("No answer was found", a1);
    assertEquals("Answer" , a2);

  }

  @Test
  void canUseOptionalWithTrade() {

    Optional<Trade> trade1 = Optional.empty();
    Optional<Trade> trade2 = Optional.of(new Trade(true, 12345, "JPMorgan"));

    //Returns the object contained inside or throws an exception
    try {
      Trade t1 = trade1.orElseThrow(IllegalArgumentException::new);
    }
    catch (IllegalArgumentException ex ) {
      //expected
    }

    //Get the trade Id for a trade or -1 if not possible
    int trade1Id = trade1.map(t -> t.getTradeId()).orElse(-1);
    int trade2Id = trade2.map(t -> t.getTradeId()).orElse(-1);

    assertEquals(-1, trade1Id);
    assertEquals(12345, trade2Id);
  }

  @Test
  void canUseOptionalInt() {
    OptionalInt intResult =  OptionalInt.of(7);
    int v = intResult.getAsInt();
  }

}
