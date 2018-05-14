package com.wylietech.demo.chapter5;

import java.util.Collections;
import java.util.List;

class MaxItemFinder {

  public static <E extends Comparable<E>> E findMaximum(List<E> items) {
    E result = null;

    //Note that we couldn't call compareTo if we hadnt specified that E must extend Comparable
    for (E item : items) {
      if (result == null || result.compareTo(item) > 0) {
        result = item;
      }

    }

    return result;
  }
}
