package com.wylietech.demo.chapter3;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{

  private final int id;
  private final String firstName;
  private final String lastName;

  private static final Comparator COMPARATOR =
      Comparator.comparingInt((Employee employee) -> employee.id)
        .thenComparing(employee -> employee.lastName)
      .thenComparing(employee -> employee.firstName);

  public Employee(String lastName, String firstName, int id) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public int compareTo(Employee o) {
    return COMPARATOR.compare(this, o);
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
