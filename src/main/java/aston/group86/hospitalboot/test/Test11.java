package aston.group86.hospitalboot.test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Test11 {

  public static void main(String[] args) {

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
        .sorted(Comparator.comparing(word->word.getValue(), Comparator.reverseOrder()))
        .limit(n)
        .map(word->word.getKey())
        .toList();
  }

}
