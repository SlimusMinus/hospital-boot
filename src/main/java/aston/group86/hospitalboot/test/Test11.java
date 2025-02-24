package aston.group86.hospitalboot.test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test11 {

  public static void main(String[] args) {
    Map<String, Integer> wordFrequency = Map.of(
        "something", 2,
        "speak", 23,
        "product", 12,
        "java", 45,
        "work", 8
    );

    wordFrequency.entrySet().stream()
        .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(2)
        .map(Entry::getKey)
        .forEach(System.out::println);
  }

  /*
   * Вывести список из n самых встречающихся слов
   */
  private static Map<String, Integer> wordFrequency = Map.of(
      "something", 2,
      "speak", 23,
      "product", 12,
      "java", 45,
      "work", 8
  );






  private static List<String> getMostFrequentWords(Map<String, Integer> wordsFrequency, Integer n) {
   return wordsFrequency.entrySet().stream()
        .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(n)
        .map(Entry::getKey)
        .toList();
  }

}
