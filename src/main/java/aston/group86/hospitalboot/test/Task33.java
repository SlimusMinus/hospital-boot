package aston.group86.hospitalboot.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class Task33 {

  public static void main(String[] args) {
    List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana");

    words.stream()
        .collect(Collectors.groupingBy(word->word, Collectors.counting()))
        .entrySet()
        .stream()
        .max(Entry.comparingByValue())
        .map(Entry::getKey)
        .ifPresent(System.out::println);

  }
}
