package com.wylietech.demo.concurrency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.Test;

class AtomicLongTest {

  @Test
  void canIncrementAndGet() {

    AtomicLong atomicLong = new AtomicLong(4);

    //Increment and get does the increment before getting - so we get the new value
    long v1 = atomicLong.incrementAndGet();
    assertEquals(5, v1);

    //Get an increment does the get and then increments -so we get the old value
    long v2 = atomicLong.getAndIncrement();
    assertEquals(5, v2);

    long v3 = atomicLong.get();
    assertEquals(6, v3);

    //Get and Set gets the old value and sets a new one (swapping the old for the new)
    long v4 = atomicLong.getAndSet(10);
    assertEquals(6, v4);
    assertEquals(10, atomicLong.get());
  }

  @Test
  void canCompareAndSet() {
    //This compares the existing value to the supplied one
    //if true then replaces it with a new one - returning bool to indicate success
    AtomicLong atomicLong = new AtomicLong(4);

    boolean succeeded = atomicLong.compareAndSet(6, 12);
    assertFalse(succeeded);
    assertEquals(4, atomicLong.get());

    boolean succeededAgain = atomicLong.compareAndSet(4, 12);
    assertTrue(succeededAgain);
    assertEquals(12, atomicLong.get());

  }

  @Test
  void canAddAndGet() {
    AtomicLong atomicLong = new AtomicLong(4);
    assertEquals(10, atomicLong.addAndGet(6));

  }

  @Test
  void canApplyOperatorAndGet() {

    //When applying functions they should be side-effect free, since they may
    //get re-applied if there are contentions

    AtomicLong atomicLong = new AtomicLong(4);
    long value = atomicLong.updateAndGet(l -> l*2);

    assertEquals(8, value);
  }

  @Test
  void canAccumulateAndGet() {

    //This allows us to take a function that receives the old value and the new
    AtomicLong atomicLong = new AtomicLong(4);

    long value = atomicLong.accumulateAndGet(8, (o, n) -> o * n);
    assertEquals(32, value);
  }


}
