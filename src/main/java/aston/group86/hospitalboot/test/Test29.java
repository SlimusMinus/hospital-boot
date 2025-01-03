package aston.group86.hospitalboot.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test29 {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 0, 4, 5, 6, 0, 7, 8, 9, 10, 0, 11, 12);

    List<Integer> integers = numbers.stream()
        .reduce(new ArrayList<List<Integer>>(Arrays.asList(new ArrayList<>())),
            (acc, num) -> {
              if (num != 0) {
                acc.get(acc.size() - 1).add(num);
              } else {
                acc.add(new ArrayList<>());
              }
              return acc;
            }, (left, right) -> {
              left.addAll(right);
              return left;
            })
        .stream()
        .max(Comparator.comparingInt(List::size)).orElse(new ArrayList<>());

    System.out.println(integers);


  }

}
