package aston.group86.hospitalboot.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Test63 {

  public static void main(String[] args) {
    String text = """
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus.
        Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt
        efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris,
        ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
        Integer vel odio nec mi tempor dignissim.
        """;

    System.out.println(mostMeetingWords(text));
  }

  //  Написать метод, который вернет 10 наиболее встречающихся слов в тексте
  //  в отсортированном по убыванию количества повторений порядке
//    Если количество повторений равно,
//    вернуть в отсортированном по убыванию длинны строки порядке
//    [consectetur=3, lorem=3, ipsum=3, adipiscing=2,
//    faucibus=2, tempor=2, dolor=2, amet=2, eget=2, vel=2]
  public static List<Entry<String, Long>> mostMeetingWords(String text) {

    String[] strings = text.toLowerCase()
        .replaceAll("\\.", "")
        .replaceAll(",", "")
        .split(" ");

    return Arrays.stream(strings)
        .collect(Collectors.groupingBy(str -> str, Collectors.counting()))
        .entrySet().stream()
        .sorted((a, b) -> {
          int compareTo = b.getValue().compareTo(a.getValue());
          if (compareTo == 0) {
            return Integer.compare(b.getKey().length(), a.getKey().length());
          }
          return compareTo;
        })
        .limit(10)
        .toList();
  }
}
