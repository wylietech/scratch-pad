package com.wylietech.demo.chapter5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SuppressWarningsTest {


  //We can suppress warnings on the following things
  //TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE}

  @SuppressWarnings("unchecked")
  void functionWithWarning(List<String> data) {

    List rawList = new ArrayList();
    rawList.add("Fred");

    data.addAll(rawList);

  }

  void functionWithWarningInlineSuppression(List<String> data) {

    //Can suppress on a variable declaration but not on an arbitrary block of code
    @SuppressWarnings("unchecked")
    List rawList = new ArrayList();

    //Cant suppress this unless its part of a variable declaration
    rawList.add("Fred");

    data.addAll(rawList);

  }

}
