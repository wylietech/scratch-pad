package com.wylietech.demo.chapter5;

import java.util.HashMap;
import java.util.Map;

class Favourites {

  private Map<Class<?>, Object> favourites = new HashMap<>();

  //Note that T can be different for each call - its a parameter on this method
  public <T> void putFavourite(Class<T> type, T instance) {
    favourites.put(type, instance);
  }

  //The class instance has the ability to dynamically cast instances - clever
  public <T> T getFavourite(Class<T> type) {
    return type.cast(favourites.get(type));
  }
}
