package aston.group86.hospitalboot.test;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Test31 {

  public static void main(String[] args) {
    List<List<Integer>> lists = List.of(
        List.of(1, 2, 3),
        List.of(4, 5, 6),
        List.of(7, 8, 9)
    );

    //сумма нечетных чисел
    Integer reduce = lists.stream()
        .flatMap(Collection::stream)
        .filter(num -> num % 2 != 0)
        .reduce(0, Integer::sum);
    System.out.println(reduce);

    //Сумма максимальных чисел каждого списка
    Integer reduce1 = lists.stream()
        .map(listNum -> listNum.stream().max(Integer::compareTo).orElse(0))
        .reduce(0, Integer::sum);
    System.out.println(reduce1);

    //Самое большое и маленькое нечетное число
    List<Integer> listSorted = lists.stream()
        .flatMap(Collection::stream)
        .filter(num -> num % 2 != 0)
        .sorted()
        .toList();

    System.out.println(listSorted.get(0) + " " + listSorted.get(listSorted.size() - 1));
  }

}
