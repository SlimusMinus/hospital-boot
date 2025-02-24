package aston.group86.hospitalboot.test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App8 {

  public static void main(String[] args) {
    List<Integer> list = List.of(1,3,4,5,1,5,4);
    Map<Integer, Long> collect = list.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    collect.forEach((key, value) -> System.out.println(key + " -> " + value));

  }

}
