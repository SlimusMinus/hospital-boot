package aston.group86.hospitalboot.test;

/*Вернуть список квадратов этих чисел без дубликатов.
2, 2, 2, 3, 4, 5, 5, 6, 7, 7, 8, 9, 9*/

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App5 {

  public static void main(String[] args) {
    List<Integer> list = List.of(2, 2, 2, 3, 4, 5, 5, 6, 7, 7, 8, 9, 9);

    List<Integer> list1 = list.stream()
        .distinct()
        .map(num -> num * num)
        .toList();

    System.out.println(list1);

    List<Integer> list2 = list.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream()
        .filter(entry -> entry.getValue() == 1)
        .map(entry-> entry.getKey() * entry.getKey())
        .toList();

    System.out.println(list2);

  }
}
