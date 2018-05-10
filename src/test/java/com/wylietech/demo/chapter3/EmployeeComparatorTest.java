package com.wylietech.demo.chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class EmployeeComparatorTest {

  @Test
  void canSort() {

    List<Employee> employees = new ArrayList<>();

    employees.add(new Employee("Zuckerberg", "Mark", 97));
    employees.add(new Employee("Effron", "Zak", 19));
    employees.add(new Employee("Alfredo", "Alfred", 26));
    employees.add(new Employee("Wylie", "Matthew", 45));
    employees.add(new Employee("Wylie", "Matthew", 12));
    employees.add(new Employee("Wylie", "Ben", 16));

    Collections.sort(employees);
    employees.forEach(System.out::println);

  }
}
