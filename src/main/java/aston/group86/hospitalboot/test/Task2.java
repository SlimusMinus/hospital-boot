package aston.group86.hospitalboot.test;

import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {

  public static void main(String[] args) {
    // Найти самый часто встречающийся элемент в стриме.
    Stream<Integer> stream = Stream.of(1, 5, 4, 3, 4, 5, 5, 2, 5, 5);

    stream.collect(Collectors.groupingBy(num->num, Collectors.counting()))
        .entrySet()
        .stream()
        .max(Entry.comparingByValue())
        .ifPresent(System.out::println);
  }

}
