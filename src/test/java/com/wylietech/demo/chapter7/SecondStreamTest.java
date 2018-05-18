package com.wylietech.demo.chapter7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class SecondStreamTest {

  private static final Random random = new Random();

  @Test
  void canSortMapAndFilter() {
    Stream<String> strings = Stream.of("a1", "a2", "b1", "c2", "c1");

    //Here we are sorting the stream
    strings.filter(s -> s.startsWith("c"))
        .map(String::toUpperCase)
        .sorted()
        .forEach(System.out::println);
  }

  @Test
  void sortingWithUnboundedStreams() {

    //Note that, without the limit, this doesnt cause a compile error or warning -
    //it just runs out of heap space
    IntStream stream = IntStream.generate(random::nextInt);

    stream.limit(20)
        .sorted()
        .forEach(System.out::println);
  }

  @Test
  void weCanSearchWithinStreams() {

    IntStream stream = IntStream.generate(random::nextInt);

    OptionalInt result = stream.limit(20)
        .findFirst();

    result.ifPresent(System.out::println);
  }

  @Test
  void primitiveStreamsSupportSumAndAverage() {

    IntStream stream = IntStream.of(1,2,3,4,5);
    int sum = stream.sum();
    assertEquals(15, sum);

    //Note that streams shouldnt be reused - this would fail if called on the same stream
    IntStream stream2 = IntStream.of(1,2,3,4,5);
    OptionalDouble average = stream2.average();
    assertEquals(3, average.getAsDouble());
  }

  @Test
  void canSortObjects() {

    Stream<Person> people = Stream.of(new Person("Matthew", "Wylie", 46),
        new Person("Lynda", "Wylie", 46),
        new Person("Ben", "Wylie", 13),
        new Person("Sam", "Wylie", 11));


    Optional<Person> youngestPerson = people.sorted()
        .findFirst();

    assertEquals("Sam", youngestPerson.get().getFirstName());

  }

  private static class Person implements Comparable<Person> {
    private String firstName;

    @Override
    public int compareTo(Person o) {
      return Integer.compare(age, o.age);
    }

    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
    }

    public String getFirstName() {
      return firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public int getAge() {
      return age;
    }

    @Override
    public String toString() {
      return "Person{" +
          "firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", age=" + age +
          '}';
    }
  }

}
