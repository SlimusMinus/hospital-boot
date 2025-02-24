package aston.group86.hospitalboot.test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Test99 {


    /*    lists.stream()
            .flatMap(listNum-> listNum.stream())
      .filter(num->num %2 != 0)
      .reduce(0, (a,b) -> a+b);*/

  public static void main(String[] args) {
    List<List<Integer>> lists = List.of(
        List.of(1, 2, 3),
        List.of(4, 5, 6),
        List.of(7, 8, 9)
    );

    Optional<Integer> reduce = lists.stream()
        .map(listNum -> listNum.stream().max(Integer::compareTo))
        .filter(Optional::isPresent)
        .map(Optional::get)
        .reduce(Integer::sum);

    System.out.println(reduce.get());
  }



}
